package com.shawn.house.engine.parse;

import com.shawn.house.web.entity.BuildingEntity;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by shawn.zeng on 2018/6/7.
 */
public class BuildingParse {

    public static List<BuildingEntity> parse(Document document,String projectCode){
        if(document == null){
            return null;
        }else {
            List<BuildingEntity> buildingEntities = new ArrayList<>();
            Element table = document.select("body > div > div.w.seachBox > div > table:nth-child(2) > tbody").get(0);
            Elements trs = table.getElementsByTag("tr");
            for(Element tr:trs){
                Elements tds = tr.getElementsByTag("td");
                if(tds.get(0).getElementsByTag("a").size() ==0){
                    continue;
                }else {
                    try{
                        BuildingEntity buildingEntity = new BuildingEntity();
                        buildingEntity.setBuildingCode(tds.get(0).childNode(1).attr("onclick").split("=")[2].split("'")[0]);
                        buildingEntity.setBuildingName(tds.get(0).childNode(1).childNode(0).toString());
                        buildingEntity.setBuildingStructure(tds.get(1) != null?tds.get(1).childNode(0).toString():null);
                        buildingEntity.setTotalFloor(tds.get(2).childNode(0).toString());
                        buildingEntity.setTotalRoom(tds.get(3).childNode(0).toString());
                        buildingEntity.setProjectCode(projectCode);
                        buildingEntities.add(buildingEntity);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
            return  buildingEntities;
        }
    }

}
