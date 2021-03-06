package com.shawn.house.v1.job;

import com.shawn.house.v1.engine.parse.ProjectParse;
import com.shawn.house.v1.engine.req.ProjectReq;
import com.shawn.house.v1.web.dao.ProjectJPA;
import com.shawn.house.v1.web.entity.PageEntity;
import com.shawn.house.v1.web.entity.ProjectEntity;
import org.apache.commons.collections.CollectionUtils;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by shawn.zeng on 2018/6/6.
 */
@Service
public class ProjectJob {

    @Autowired
    private ProjectJPA projectJPA;


    public void job(){
        List<ProjectEntity> projectEntityList = projectJPA.findAll();
        ProjectReq projectReq = new ProjectReq();
        Document document = null;
        document = projectReq.getDocument(null);
        List<ProjectEntity> projectEntities = ProjectParse.parse(document);
        projectEntities.removeAll(projectEntityList);
        if(CollectionUtils.isNotEmpty(projectEntities)){
            projectJPA.saveAll(projectEntities);
        }
        PageEntity pageEntity = ProjectParse.getPage(document);
        int totalPage = (Integer.valueOf(pageEntity.getProjectCount())+19)/20;
        for(int i=1;i<totalPage;i++){
            projectReq.setPageNo(String.valueOf(i));
            try {
                document = projectReq.getDocument(null);
                System.out.println("获取第"+i+"页数据成功");
                TimeUnit.SECONDS.sleep(2);
            }  catch (InterruptedException e) {
                e.printStackTrace();
            }
            projectEntities = ProjectParse.parse(document);
            projectEntities.removeAll(projectEntityList);
            if(CollectionUtils.isNotEmpty(projectEntities)){
                projectJPA.saveAll(projectEntities);
            }
        }
    }

    public static void main(String[] args) {
        new ProjectJob().job();
    }
}
