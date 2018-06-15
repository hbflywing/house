package com.shawn.house.v1.engine.queue.common;

/**
 * Created by shawn.zeng on 2018/6/9.
 */
public interface Model {
    Runnable newRunnableConsumer();
    Runnable newRunnableProducer();
}
