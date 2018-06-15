package com.shawn.house.v1.engine.parse;

import com.shawn.house.v1.web.entity.RoomEntity;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Created by shawn.zeng on 2018/6/7.
 */
public class PriceParse {
    public static RoomEntity parse(Document document){
        if(document == null){
            return null;
        }
        RoomEntity roomEntity = new RoomEntity();
        try{
            Element previousArea = document.select("#form1 > div.container > table > tbody > tr:nth-child(3) > td:nth-child(3)").get(0);
            Element actualArea = document.select("#form1 > div.container > table > tbody > tr:nth-child(4) > td:nth-child(3)").get(0);
            Element price = document.select("#form1 > div.container > table > tbody > tr:nth-child(5) > td:nth-child(3) > img").get(0);
            roomEntity.setPreviousArea(previousArea.childNodes().size() ==1?previousArea.childNode(0).toString():null);
            roomEntity.setActualArea(actualArea.childNodes().size() == 1?actualArea.childNode(0).toString():null);
            roomEntity.setPrice(price.attr("src").split("price=")[1]);
        }catch (Exception e){
            return null;
        }

        return roomEntity;
    }
}
