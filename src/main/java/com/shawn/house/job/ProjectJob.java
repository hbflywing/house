package com.shawn.house.job;

import com.shawn.house.engine.parse.ProjectParse;
import com.shawn.house.engine.req.ProjectReq;
import com.shawn.house.web.dao.ProjectJPA;
import com.shawn.house.web.entity.PageEntity;
import com.shawn.house.web.entity.ProjectEntity;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        try {
            document = projectReq.getDocument();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<ProjectEntity> pros = new ArrayList<>();
        List<ProjectEntity> projectEntities = ProjectParse.parse(document);
        pros.addAll(projectEntities);
        PageEntity pageEntity = ProjectParse.getPage(document);
        int totalPage = (Integer.valueOf(pageEntity.getProjectCount())+19)/20;
        for(int i=1;i<totalPage;i++){
            projectReq.setPageNo(String.valueOf(i));
            try {
                document = projectReq.getDocument();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pros.addAll(ProjectParse.parse(document));
        }
        pros.removeAll(projectEntityList);
        projectJPA.saveAll(pros);
    }

    public static void main(String[] args) {
        new ProjectJob().job();
    }
}
