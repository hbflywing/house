package com.shawn.house;

import com.shawn.house.engine.parse.RoomParse;
import com.shawn.house.engine.req.RoomReq;
import com.shawn.house.web.entity.RoomEntity;

import java.io.IOException;
import java.util.List;

public class TestFetchRoom {
    public static void main(String[] args) throws IOException {
        RoomReq roomReq = new RoomReq();
        roomReq.setDengJh("湖1800071");
        roomReq.setHouseDengJh("湖0007424");
        List<RoomEntity> list = RoomParse.parse(roomReq.getDocument(),roomReq.getHouseDengJh());
    }
}
