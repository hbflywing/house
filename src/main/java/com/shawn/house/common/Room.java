package com.shawn.house.common;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Room {
    private String gids;

    private String buildingCode;

    private String unit;

    private String floor;

    private String roomNo;

    private String roomPrice;

}
