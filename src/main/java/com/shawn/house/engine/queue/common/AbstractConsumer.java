package com.shawn.house.engine.queue.common;

import java.io.IOException;

/**
 * Created by shawn.zeng on 2018/6/9.
 */
public abstract class AbstractConsumer implements Consumer, Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
