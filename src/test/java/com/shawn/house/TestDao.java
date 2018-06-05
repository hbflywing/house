package com.shawn.house;

import ch.qos.logback.core.util.TimeUtil;
import com.shawn.house.engine.FetchUtil;
import com.shawn.house.web.dao.BuildingRepository;
import com.shawn.house.web.dao.ProjectRepository;
import com.shawn.house.web.dao.RoomRepository;
import com.shawn.house.web.dao.TotalRepository;
import com.shawn.house.web.entity.Building;
import com.shawn.house.web.entity.Project;
import com.shawn.house.web.entity.Total;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by shawn.zeng on 2018/6/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=HouseApplication.class)
public class TestDao {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    TotalRepository totalRepository;

    @Autowired
    BuildingRepository  buildingRepository;

    @Autowired
    RoomRepository roomRepository;

    @Test
    public void test(){

        Total total = FetchUtil.total;
        for(int i=1;i<=total.getTotalPage();i++){
            List<Project> projects = FetchUtil.fetchProject(i);
            projectRepository.saveAll(projects);
            System.out.println("第"+i+"页抓取成功");
        }

    }

    @Test
    public void test1(){

        List<Project> projects = projectRepository.findAll();
        int i = 0;
        for(Project project:projects){
            List result = buildingRepository.findAll(new Example<Building>() {
                @Override
                public Building getProbe() {
                    return Building.builder().projectNo(project.getProjectNo()).build();
                }

                @Override
                public ExampleMatcher getMatcher() {
                    return ExampleMatcher.matching();
                }
            });
            if(CollectionUtils.isNotEmpty(result)){
                System.out.println("第"+i+"个项目"+project.getProjectNo()+"已经被抓取");
                i++;
                continue;
            }
            try{
                List<Building> buildingList = FetchUtil.fetchBuilding(project.getProjectNo());
                buildingRepository.saveAll(buildingList);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("第"+i+"个项目"+project.getProjectNo()+" 抓取成功");
                i++;
            } catch (Exception e){
                System.out.println("第"+i+"个项目"+project.getProjectNo()+" 抓取失败");
                i++;
            }


        }

    }


    @Test
    public void test2(){
        List<Project> projects = projectRepository.findAll();

    }
    @Test
    public void test3(){


    }
}
