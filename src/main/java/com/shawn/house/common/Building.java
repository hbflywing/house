package com.shawn.house.common;

import lombok.Builder;
import lombok.ToString;

@ToString
@Builder
public class Building {

    private String buildingName;

    private String buildingNo;

    private String buildingStructure;

    private String totalFloor;

    private String totalRoom;
}
