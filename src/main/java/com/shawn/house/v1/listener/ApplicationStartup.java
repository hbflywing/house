package com.shawn.house.v1.listener;

import com.shawn.house.v1.job.BuildingJob;
import com.shawn.house.v1.job.RoomJob;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by shawn.zeng on 2018/6/9.
 */
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //contextRefreshedEvent.getApplicationContext().getBean(BuildingJob.class).job1();
        contextRefreshedEvent.getApplicationContext().getBean(RoomJob.class).job1();
        //contextRefreshedEvent.getApplicationContext().getBean(RoomJob.class).job2();
    }
}
