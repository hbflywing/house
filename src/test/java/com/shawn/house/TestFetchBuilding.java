package com.shawn.house;

import com.shawn.house.engine.parse.BuildingParse;
import com.shawn.house.engine.req.BuildingReq;
import com.shawn.house.web.entity.BuildingEntity;

import java.io.IOException;
import java.util.List;

public class TestFetchBuilding {
    public static void main(String[] args) throws IOException {
        BuildingReq buildingReq = new BuildingReq();
        buildingReq.setDengJh("黄1800294");
        List<BuildingEntity> buildingEntities = BuildingParse.parse(buildingReq.getDocument(),buildingReq.getDengJh());
    }
}
