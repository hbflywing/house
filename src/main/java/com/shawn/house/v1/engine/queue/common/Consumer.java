package com.shawn.house.v1.engine.queue.common;

import java.io.IOException;

/**
 * Created by shawn.zeng on 2018/6/9.
 */
public interface Consumer {
    void consume() throws InterruptedException, IOException;
}
