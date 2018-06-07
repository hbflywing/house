package com.shawn.house.engine.parse;

import com.shawn.house.web.entity.RoomEntity;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shawn.zeng on 2018/6/7.
 */
public class RoomParse {
    public static List<RoomEntity> parse(Document document,String buildingCode){
        Element table = document.select("body > div > div.w.seachBox > div > div > table > tbody").get(0);
        Elements trs = table.getElementsByTag("tr");
        List<RoomEntity> roomEntities = new ArrayList<>();
        for(Element tr:trs){
            Elements tds = tr.getElementsByTag("td");
            if(tds.size() == 0){
                continue;
            }else {
                String buidingNo = tds.get(0).childNode(0).toString().trim();
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
