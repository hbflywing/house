package com.shawn.house.web.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@ToString
@Builder
@Data
public class Building {

    @Id
    private String id;

    private String buildingName;

    private String buildingNo;

    private String buildingStructure;

    private String totalFloor;

    private String totalRoom;

    private String projectNo;
}
