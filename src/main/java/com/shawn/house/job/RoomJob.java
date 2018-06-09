package com.shawn.house.job;

import com.shawn.house.engine.parse.RoomParse;
import com.shawn.house.engine.queue.BlockingQueueRoom;
import com.shawn.house.engine.queue.BlockingQueueStringPrice;
import com.shawn.house.engine.req.RoomReq;
import com.shawn.house.web.dao.BuildingJPA;
import com.shawn.house.web.dao.RoomJPA;
import com.shawn.house.web.entity.BuildingEntity;
import com.shawn.house.web.entity.RoomEntity;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by shawn.zeng on 2018/6/6.
 */
@Service
public class RoomJob {

    @Autowired
    private RoomJPA roomJPA;

    @Autowired
    private BuildingJPA buildingJPA;

    @Autowired
    private BlockingQueueRoom blockingQueueRoom;

    @Autowired
    private BlockingQueueStringPrice blockingQueueStringPrice;

    public void job() throws IOException, InterruptedException {
        List<BuildingEntity> buildingEntities = buildingJPA.findAll();
        for(BuildingEntity buildingEntity:buildingEntities){
            List<RoomEntity> roomEntities = roomJPA.findAll(new Example<RoomEntity>() {
                @Override
                public RoomEntity getProbe() {
                    RoomEntity roomEntity = new RoomEntity();
                    roomEntity.setBuildingCode(buildingEntity.getBuildingCode());
                    return roomEntity;
                }

                @Override
                public ExampleMatcher getMatcher() {
                    return ExampleMatcher.matching();
                }
            });

            if(CollectionUtils.isNotEmpty(roomEntities)){
                System.out.println(buildingEntity.getProjectCode()+"     "+buildingEntity.getBuildingCode()+" room alrealy read");
            }else {
                RoomReq roomReq = new RoomReq();
                roomReq.setDengJh(buildingEntity.getProjectCode());
                roomReq.setHouseDengJh(buildingEntity.getBuildingCode());
                List<RoomEntity> result = RoomParse.parse(roomReq.getDocument(),buildingEntity.getBuildingCode());
                if(CollectionUtils.isNotEmpty(result)){
                    roomJPA.saveAll(result);
                    System.out.println(buildingEntity.getBuildingCode()+"房间已经保存成功");
                }
                TimeUnit.SECONDS.sleep(2);
            }
        }
    }

    public void job1(){
        new Thread(blockingQueueRoom.newRunnableProducer()).start();
        new Thread(blockingQueueRoom.newRunnableConsumer()).start();
    }

    public void job2(){
        new Thread(blockingQueueStringPrice.newRunnableProducer()).start();
        new Thread(blockingQueueStringPrice.newRunnableConsumer()).start();
    }
}
