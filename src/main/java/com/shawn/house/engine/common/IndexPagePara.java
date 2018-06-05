package com.shawn.house.engine.common;

import lombok.Data;
import lombok.ToString;

/**
 * 查询房价首页参数
 * Created by shawn.zeng on 2018/6/1.
 */

@Data
@ToString
public class IndexPagePara {

    public static final String url= "http://scxx.fgj.wuhan.gov.cn/xmqk.asp";

    //行政区域
    private String domain;
    //项目名称
    private String blname;
    //项目地址
    private String bladdr;
    //开发商
    private String prname;
    //还不知道
    private String Submit2222;
    //当前页数
    private Integer page=1;
}
