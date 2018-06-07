package com.shawn.house.engine.parse;

import com.shawn.house.web.entity.ProjectEntity;
import org.jsoup.nodes.Document;


/**
 * Created by shawn.zeng on 2018/6/7.
 */
public class ProjectDetailParse {

    public static ProjectEntity parse(Document document){
        ProjectEntity projectEntity = new ProjectEntity();
        if(document == null){
            return null;
        }else {
            projectEntity.setProjectName(document.getElementById("xiangmmc").childNode(0).toString().trim());
            projectEntity.setLocation(document.getElementById("MenPhm").childNode(0).toString().trim());
            projectEntity.setStartWorkingTime(document.getElementById("kaigsj").childNode(0).toString().trim());
            projectEntity.setCompletionTime(document.getElementById("jungsj").childNode(0).toString().trim());
            projectEntity.setUseArea(document.getElementById("TuDmj").childNode(0).toString().trim());
            projectEntity.setAreaYear(document.getElementById("ShiYnx").childNode(0).toString().trim());
            projectEntity.setAreaPurpose(document.getElementById("TuDyt").childNode(0).toString().trim());
            projectEntity.setAreaLevel(document.getElementById("TuDdj").childNode(0).toString().trim());
            projectEntity.setFloorage(document.getElementById("JianZmj").childNode(0).toString().trim());
            projectEntity.setPlotRatio(document.getElementById("rongjl").childNode(0).toString().trim());
            projectEntity.setTotalBuilding(document.getElementById("ZDongS").childNode(0).toString().trim());
            projectEntity.setSaleTime(document.getElementById("xiaossj").childNode(0).toString().trim());
            projectEntity.setOthers(document.getElementById("TaXql").childNode(0).toString().trim());
            projectEntity.setBuildingAreaCode(document.getElementById("JianzYDGHXKZH").childNode(0).toString().trim());
            projectEntity.setAreaCode(document.getElementById("TuDsyqzh").childNode(0).toString().trim());
            projectEntity.setBuildingDesignCode(document.getElementById("JianZghxkzh").childNode(0).toString().trim());
            projectEntity.setConstructionCode(document.getElementById("ShiGxkzh").childNode(0).toString().trim());
            projectEntity.setPreviousCode(document.getElementById("shangPfysxkz").childNode(0).toString().trim());
            projectEntity.setCompanyCode(document.getElementById("KaiFQYZZ").childNode(0).toString().trim());
            projectEntity.setCompanyName(document.getElementById("KaiFs").childNode(0).toString().trim());
            projectEntity.setCompanyTel(document.getElementById("LianXdh").childNode(0).toString().trim());
            projectEntity.setAgentCompany(document.getElementById("daiLGS").childNode(0).toString().trim());
            projectEntity.setAgentTel(document.getElementById("daiLGSLXDH").childNode(0).toString().trim());
            projectEntity.setOffice(document.getElementById("shiqs").childNode(0).toString().trim());
            return projectEntity;
        }

    }
}
