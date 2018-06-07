package com.shawn.house;

import com.shawn.house.engine.parse.PriceParse;
import com.shawn.house.engine.req.PriceReq;
import com.shawn.house.web.entity.RoomEntity;

import java.io.IOException;

public class TestRoomFetch {
    public static void main(String[] args) throws IOException {
        PriceReq priceReq = new PriceReq();
        priceReq.setGid("59627F6E-1325-4A51-A0A3-6C1E954617E0");
        RoomEntity roomEntity = PriceParse.parse(priceReq.getDocument());
    }
}
