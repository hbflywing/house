package com.shawn.house.engine.queue;

import com.shawn.house.engine.parse.PriceParse;
import com.shawn.house.engine.queue.common.*;
import com.shawn.house.engine.req.PriceReq;
import com.shawn.house.web.dao.RoomJPA;
import com.shawn.house.web.entity.RoomEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.io.IOException;
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
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }
    private class ProducerImpl extends AbstractProducer implements Producer, Runnable {
        @Override
        public void produce() throws InterruptedException {
            Page<RoomEntity> page = roomJPA.findByRoomCodeNotAndPrice("00000000-0000-0000-0000-000000000000","",new PageRequest(0,1000));
            do {
                List<RoomEntity> roomEntityList = page.getContent();
                roomEntityList.stream().forEach(a-> {
                    try {
                        queue.put(a);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                page = roomJPA.findByRoomCodeNotAndPrice("00000000-0000-0000-0000-000000000000","",page.nextPageable());
            }while(page.hasNext());
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
