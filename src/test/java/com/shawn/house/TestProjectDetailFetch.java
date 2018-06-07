package com.shawn.house;

import com.shawn.house.engine.parse.ProjectDetailParse;
import com.shawn.house.engine.req.ProjectDetailReq;
import com.shawn.house.web.entity.ProjectEntity;

import java.io.IOException;

public class TestProjectDetailFetch {
    public static void main(String[] args) throws IOException {
        ProjectDetailReq projectDetailReq = new ProjectDetailReq();
        projectDetailReq.setDengJh("黄1800294");
        ProjectEntity projectEntity = ProjectDetailParse.parse(projectDetailReq.getDocument());
    }
}
