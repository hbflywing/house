package com.shawn.house.web.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by shawn.zeng on 2018/6/4.
 */
@Data
public class Total {
    @Id
    private String id;

    private Integer totalNumber;

    private Integer totalPage = 1;

    private Date updateDate;

}
