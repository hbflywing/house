package com.shawn.house.engine.parse;

import com.shawn.house.web.entity.PageEntity;
import com.shawn.house.web.entity.ProjectEntity;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shawn.zeng on 2018/6/7.
 */
public class ProjectParse {

    public static List<ProjectEntity> parse(Document document){
        List<ProjectEntity> result = new ArrayList<>();
        Elements elements  = document.select(".tabls > table:nth-child(1)");
        if(elements == null){
            return null;
        }else {
            Elements trs = elements.get(0).getElementsByTag("tr");

            for(Element elementTr:trs){
                ProjectEntity projectEntity = new ProjectEntity();
                Elements tds = elementTr.getElementsByTag("td");
                if(tds.size() == 0){
                    continue;
                }
                projectEntity.setProjectCode(tds.get(0).childNode(0).attr("href").split("=")[1]);
                projectEntity.setProjectName(tds.get(0).childNode(0).childNode(0).toString().trim());
                projectEntity.setTotal(tds.get(1).childNode(0).toString().trim());
                projectEntity.setHouseSaled(tds.get(2).childNode(0).toString().trim());
                projectEntity.setHouseSaleable(tds.get(3).childNode(0).toString().trim());
                projectEntity.setNohouseSaled(tds.get(4).childNode(0).toString().trim());
                projectEntity.setNohouseSaled(tds.get(5).childNode(0).toString().trim());
                result.add(projectEntity);
            }
        }
        return result;
    }

    public static PageEntity getPage(Document document){
        PageEntity result = new PageEntity();
        Elements elements = document.select(".page");
        if(elements == null){
            return null;
        }else {
            Pattern p=Pattern.compile("共(.*?)条记录");
            Matcher m=p.matcher(elements.get(0).childNode(0).toString());
            while (m.find()){
                result.setProjectCount(m.group(1).trim());
            }
            return result;
        }
    }
}
