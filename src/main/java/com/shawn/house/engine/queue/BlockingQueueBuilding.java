package com.shawn.house.engine.queue;

import com.shawn.house.engine.parse.RoomParse;
import com.shawn.house.engine.queue.common.*;
import com.shawn.house.engine.req.RoomReq;
import com.shawn.house.web.dao.BuildingJPA;
import com.shawn.house.web.dao.RoomJPA;
import com.shawn.house.web.entity.BuildingEntity;
import com.shawn.house.web.entity.RoomEntity;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by shawn.zeng on 2018/6/9.
 */
@Service
public class BlockingQueueBuilding implements Model {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final BlockingQueue<BuildingEntity> queue = new LinkedBlockingQueue<>(1000);

    @Autowired
    private RoomJPA roomJPA;

    @Autowired
    private BuildingJPA buildingJPA;

    @Override
    public Runnable newRunnableConsumer() {
        return new BlockingQueueBuilding.ConsumerImpl();
    }
    @Override
    public Runnable newRunnableProducer() {
        return new BlockingQueueBuilding.ProducerImpl();
    }


    private class ConsumerImpl extends AbstractConsumer implements Consumer, Runnable {
        @Override
        public void consume() throws InterruptedException, IOException {
            BuildingEntity buildingEntity = queue.take();
            //在队列中获取一个building然后去抓取他的room
            RoomReq roomReq = new RoomReq();
            roomReq.setDengJh(buildingEntity.getProjectCode());
            roomReq.setHouseDengJh(buildingEntity.getBuildingCode());
            List<RoomEntity> result = null;
            try {

                 result = RoomParse.parse(roomReq.getDocument(),buildingEntity.getBuildingCode());
            }catch (IOException exception){
                //如果发生异常就将他放到队列尾部
                logger.info(buildingEntity.getBuildingCode()+" fetch error");
                queue.put(buildingEntity);
            }
            if(CollectionUtils.isNotEmpty(result)){
                roomJPA.saveAll(result);
                System.out.println(buildingEntity.getProjectCode()+"     "+buildingEntity.getBuildingCode()+"房间已经保存成功");
            }
            //休眠一秒钟
            TimeUnit.SECONDS.sleep(1);

        }
    }

    private class ProducerImpl extends AbstractProducer implements Producer, Runnable {
        @Override
        public void produce() {
            List<BuildingEntity> buildingEntities = buildingJPA.queryBuildingEntitiesByNoRoom();
            buildingEntities.stream().forEach(a-> {
                try {
                    queue.put(a);
                    logger.info(a.getBuildingCode()+" push into queue to fetch ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
