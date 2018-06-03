package com.shawn.house.common;


import lombok.Data;

@Data
public class ProjectDetail {
    //项目坐落
    private String projectLocation;

    //项目开工时间
    private String projectStart;

    //竣工时间
    private String projectFinish;
}
