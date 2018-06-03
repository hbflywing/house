package com.shawn.house.common;

import lombok.Builder;
import lombok.Data;

/**
 * Created by shawn.zeng on 2018/6/1.
 */

@Data
@Builder
public class Project {

    //项目名称
    private String projectName;

    //项目代号
    private String projectNo;

    //总套数
    private String totalNumber;

    //住房已经售出
    private String houseSaledNumber;
    //住房可售
    private String houseSaleableNumber;
    //非住房已售
    private String nohouseSaledNumber;
    //非住房可售
    private String nohouseSaleableNumber;

}
