package com.shawn.house.v1.job;

import com.shawn.house.v1.engine.parse.BuildingParse;
import com.shawn.house.v1.engine.queue.BlockingQueueBuilding;
import com.shawn.house.v1.engine.req.BuildingReq;
import com.shawn.house.v1.web.dao.BuildingJPA;
import com.shawn.house.v1.web.dao.ProjectJPA;
import com.shawn.house.v1.web.entity.BuildingEntity;
import com.shawn.house.v1.web.entity.ProjectEntity;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by shawn.zeng on 2018/6/6.
 */
@Service
public class BuildingJob {

    @Autowired
    private BuildingJPA buildingJPA;

    @Autowired
    private ProjectJPA projectJPA;

    @Autowired
    private BlockingQueueBuilding blockingQueueBuilding;

    public void job() throws InterruptedException {

        List<ProjectEntity> projectEntities = projectJPA.findAll();

        for(ProjectEntity projectEntity:projectEntities){
            List<BuildingEntity> buildingEntities = buildingJPA.findAll(new Example<BuildingEntity>() {
                @Override
                public BuildingEntity getProbe() {
                    BuildingEntity buildingEntity= new BuildingEntity();
                    buildingEntity.setProjectCode(projectEntity.getProjectCode());
                    return buildingEntity;
                }

                @Override
                public ExampleMatcher getMatcher() {
                    return ExampleMatcher.matching();
                }
            });
            if(CollectionUtils.isEmpty(buildingEntities)){
                BuildingReq buildingReq = new BuildingReq();
                buildingReq.setDengJh(projectEntity.getProjectCode());
                List<BuildingEntity> buildingEntityList = new ArrayList<>();
                buildingEntityList = BuildingParse.parse(buildingReq.getDocument(),projectEntity.getProjectCode());
                if(CollectionUtils.isNotEmpty(buildingEntityList)){
                    buildingJPA.saveAll(buildingEntityList);
                    System.out.println(projectEntity.getProjectCode()+"楼栋抓取成功");
                    TimeUnit.SECONDS.sleep(2);
                }
            }else {
                System.out.println(projectEntity.getProjectCode()+"楼栋已经被抓取过");
            }
        }
    }

    public void job1(){
        Thread t1 = new Thread(blockingQueueBuilding.newRunnableConsumer());
        t1.setName("获取楼栋的房间房间线程");
        t1.start();
        Thread t2 = new Thread(blockingQueueBuilding.newRunnableProducer());
        t2.setName("获取还没有抓取房间的线程");
        t2.start();
    }

}
