package com.shawn.house.v1.engine.parse;

import com.shawn.house.v1.web.entity.RoomEntity;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shawn.zeng on 2018/6/7.
 */
public class RoomParse {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public static List<RoomEntity> parse(Document document, String buildingCode){
        if(document.select("body > div > div.w.seachBox > div > div > table > tbody")==null){
            LoggerFactory.getLogger(Thread.currentThread().getName()).info(buildingCode+" can find room list");
            return null;
        }
        Element table = document.select("body > div > div.w.seachBox > div > div > table > tbody").get(0);
        Elements trs = table.getElementsByTag("tr");
        List<RoomEntity> roomEntities = new ArrayList<>();
        for(Element tr:trs){
            Elements tds = tr.getElementsByTag("td");
            if(tds.size() == 0){
                continue;
            }else {
                String buidingNo = tds.get(0).childNode(0).toString().trim();
                if(buidingNo.equals("没有找到您要的数据")){
                    LoggerFactory.getLogger(Thread.currentThread().getName()).info(buildingCode+" can find room list");
                    break;
                }
                String unit = tds.get(1).childNode(0).toString().trim();
                String floor = tds.get(2).childNode(0).toString().trim();
                for(int j=3;j<tds.size();j++){
                    RoomEntity roomEntity = new RoomEntity();
                    roomEntity.setBuildingNo(buidingNo);
                    roomEntity.setUnit(unit);
                    roomEntity.setFloor(floor);
                    Element element = tds.get(j);
                    String color = element.attr("bgcolor");
                    switch (color){
                        case "#FF0000":
                            roomEntity.setStatus((byte)1);
                            break;
                        case "#CCFFFF":
                            roomEntity.setStatus((byte)2);
                            break;
                        case "#000000":
                            roomEntity.setStatus((byte)3);
                            break;
                        case "#FFFF00":
                            roomEntity.setStatus((byte)4);
                            break;
                        case "#CC0099":
                            roomEntity.setStatus((byte)5);
                            break;
                    }
                    if(element.getElementsByTag("a").size() !=0){
                        roomEntity.setRoomCode(element.getElementsByTag("a").get(0).attr("href").split("=")[1]);
                        roomEntity.setRoomNo(element.getElementsByTag("a").get(0).childNode(0).toString());
                    }
                    roomEntity.setBuildingCode(buildingCode);
                    roomEntities.add(roomEntity);
                }
            }
        }
        return roomEntities;
    }
}
