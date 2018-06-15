package com.shawn.house.v1.engine.queue;

import com.shawn.house.v1.engine.parse.PriceParse;
import com.shawn.house.v1.engine.queue.common.*;
import com.shawn.house.v1.engine.req.PriceReq;
import com.shawn.house.v1.web.dao.RoomJPA;
import com.shawn.house.v1.web.entity.RoomEntity;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by shawn.zeng on 2018/6/9.
 */
@Service
public class BlockingQueueRoom implements Model{

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final String NOT_FRICE_CODE = "00000000-0000-0000-0000-000000000000";

    private static final String EMPTY_STRING = "";

    private static final String ERROR_ROOM_CODE = "-1";

    private static final PageRequest pageRequest = new PageRequest(0,1000);

    private final BlockingQueue<RoomEntity> queue = new LinkedBlockingQueue<>(1000);

    @Autowired
    private RoomJPA roomJPA;


    @Override
    public Runnable newRunnableConsumer() {
        return new ConsumerImpl();
    }
    @Override
    public Runnable newRunnableProducer() {
        return new ProducerImpl();
    }


    private class ConsumerImpl extends AbstractConsumer implements Consumer, Runnable {
        @Override
        public void consume() throws InterruptedException {

            RoomEntity roomEntity = queue.take();
            PriceReq priceReq = new PriceReq();
            priceReq.setGid(roomEntity.getRoomCode());
            logger.info("start fetch room id = "+roomEntity.getId()+" price code ");
            RoomEntity priceRoomEntity;
            priceRoomEntity = PriceParse.parse(priceReq.getDocument());
            logger.info("start fetch room id = "+roomEntity.getId()+" price code success ");
            if(priceRoomEntity != null){
                roomEntity.setPreviousArea(priceRoomEntity.getPreviousArea());
                roomEntity.setActualArea(priceRoomEntity.getActualArea());
                roomEntity.setPrice(priceRoomEntity.getPrice());
                roomJPA.save(roomEntity);
                logger.info("price fetch success "+roomEntity.toString());
            }else{
                roomEntity.setRoomCode(ERROR_ROOM_CODE);
                roomEntity.setPrice(EMPTY_STRING);
                roomJPA.save(roomEntity);
                logger.info("fetch price by romm code err! reset room code! room id = "+roomEntity.getId());
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }
    private class ProducerImpl extends AbstractProducer implements Producer, Runnable {
        @Override
        public void produce() throws InterruptedException {
            logger.info("start find all Room need to fetch price");
            Page<RoomEntity> page = roomJPA.findByRoomCodeNotAndPrice(NOT_FRICE_CODE,EMPTY_STRING,pageRequest);
            if(CollectionUtils.isEmpty(page.getContent())){
                logger.info("no room need to fetch price");
                TimeUnit.HOURS.sleep(1);
                return;
            }

            do {
                List<RoomEntity> roomEntityList = page.getContent();
                for(RoomEntity roomEntity:roomEntityList){
                    logger.info("push room id = "+roomEntity.getId()+" to fetch price");
                    queue.put(roomEntity);
                }
                page = roomJPA.findByRoomCodeNotAndPrice(NOT_FRICE_CODE,EMPTY_STRING,page.nextPageable());
            } while (page.hasNext());
            boolean flag = true;
            while(flag ){
                if(queue.size() == 0){
                    flag = false;
                }
                TimeUnit.SECONDS.sleep(5);
            }
        }
    }

}
