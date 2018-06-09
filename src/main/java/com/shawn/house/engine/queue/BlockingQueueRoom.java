package com.shawn.house.engine.queue;

import com.shawn.house.engine.queue.common.*;
import com.shawn.house.job.RoomJob;
import com.shawn.house.web.entity.RoomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by shawn.zeng on 2018/6/9.
 */
@Service
public class BlockingQueueRoom implements Model{
    private final BlockingQueue<RoomEntity> queue = new LinkedBlockingQueue<>(1000);;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);

    @Autowired
    private RoomJob roomJob;


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


        }
    }
    private class ProducerImpl extends AbstractProducer implements Producer, Runnable {
        @Override
        public void produce() throws InterruptedException {
            // 不定期生产，模拟随机的用户请求

        }
    }

}
