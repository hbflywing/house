package com.shawn.house.web.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ProjectDetail {

    @Id
    private String id;
    //项目坐落
    private String projectLocation;

    //项目开工时间
    private String projectStart;

    //竣工时间
    private String projectFinish;
}
