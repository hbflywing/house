package com.shawn.house.engine.queue.common;

/**
 * Created by shawn.zeng on 2018/6/9.
 */
public abstract class AbstractProducer implements Producer, Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
