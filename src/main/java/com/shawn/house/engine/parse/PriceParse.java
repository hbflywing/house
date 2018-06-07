package com.shawn.house.engine.parse;

import com.shawn.house.web.entity.RoomEntity;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by shawn.zeng on 2018/6/7.
 */
public class PriceParse {
    public static RoomEntity parse(Document document) throws IOException {
        RoomEntity roomEntity = new RoomEntity();
        Element previousArea = document.select("#form1 > div.container > table > tbody > tr:nth-child(3) > td:nth-child(3)").get(0);
        Element actualArea = document.select("#form1 > div.container > table > tbody > tr:nth-child(4) > td:nth-child(3)").get(0);
        Element price = document.select("#form1 > div.container > table > tbody > tr:nth-child(5) > td:nth-child(3) > img").get(0);
        roomEntity.setPreviousArea(previousArea.childNode(0).toString());
        roomEntity.setActualArea(actualArea.childNode(0).toString());
        roomEntity.setPrice(price.attr("src").split("price=")[1]);
        return roomEntity;
    }
}
