package com.shawn.house.web.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Builder
@ToString
@Data
public class Room {

    @Id
    private String id;

    private String gids;

    private String buildingCode;

    private String unit;

    private String floor;

    private String roomNo;

    private String roomPrice;

}
