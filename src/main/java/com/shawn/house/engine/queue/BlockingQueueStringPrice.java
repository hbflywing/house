package com.shawn.house.engine.queue;

import com.shawn.house.engine.queue.common.*;
import com.shawn.house.engine.util.BaiduApiUtil;
import com.shawn.house.engine.util.TessUtil;
import com.shawn.house.web.dao.RoomJPA;
import com.shawn.house.web.entity.RoomEntity;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by shawn.zeng on 2018/6/9.
 */
@Service
public class BlockingQueueStringPrice implements Model {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final PageRequest pageRequest = new PageRequest(0,1000);

    private final BlockingQueue<RoomEntity> queue = new LinkedBlockingQueue<>(1000);

    private static final String EMPTY_STRING = "";

    @Autowired
    private RoomJPA roomJPA;


    @Override
    public Runnable newRunnableConsumer() {
        return new BlockingQueueStringPrice.ConsumerImpl();
    }
    @Override
    public Runnable newRunnableProducer() {
        return new BlockingQueueStringPrice.ProducerImpl();
    }

    private class ConsumerImpl extends AbstractConsumer implements Consumer, Runnable {
        @Override
        public void consume() throws InterruptedException {
            logger.info("start String price");
            RoomEntity roomEntity = queue.take();
            BaiduApiUtil.decode(roomEntity);
            roomJPA.save(roomEntity);
            TimeUnit.SECONDS.sleep(1);
        }
    }
    private class ProducerImpl extends AbstractProducer implements Producer, Runnable {
        @Override
        public void produce() throws InterruptedException {
            logger.info("start process room string price");
            Page<RoomEntity> page = roomJPA.findByPriceNot(EMPTY_STRING,pageRequest);
            if(CollectionUtils.isEmpty(page.getContent())){
                logger.info("no room need to fetch string price");
                TimeUnit.HOURS.sleep(1);
                return;
            }

            do{
                List<RoomEntity> rooms = page.getContent();
                for(RoomEntity roomEntity:rooms){
                    queue.put(roomEntity);
                }
                page = roomJPA.findByPriceNot(EMPTY_STRING,page.nextPageable());
            }while (page.hasNext());
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
