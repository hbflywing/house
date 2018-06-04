package com.shawn.house.engine;

import com.shawn.house.common.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class FetchUtil {

    //获取项目
    public static List<Project> fetchProject(){
        Document document = null;
        try {
            document =Jsoup.connect(IndexPagePara.url).timeout(3000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = document.select("body > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > " +
                "td > table:nth-child(2) > tbody > tr > td > table > tbody > tr:nth-child(3) " +
                "> td > table > tbody > tr > td > table:nth-child(2) > tbody").get(0).getElementsByTag("tr");
        //获取所有table节点
        List<Project> projects = new ArrayList<>();
        for(int i=2;i < elements.size();i++){
            Elements eles = elements.get(i).getElementsByTag("td");
            String projectNo = eles.get(0).getElementsByTag("a").get(0).getElementsByTag("a").get(0).attr("href").substring(12).trim();
            String projectName = eles.get(0).getElementsByTag("span").get(0).childNode(0).toString().trim();
            String totalNumber = eles.get(1).childNode(0).toString().replace("&nbsp;","").trim();
            String houseSaledNumber = eles.get(2).childNode(0).toString().replace("&nbsp;","").trim();
            String houseSaleableNumber = eles.get(3).childNode(0).toString().replace("&nbsp;","").trim();
            String nohouseSaledNumber = eles.get(4).childNode(0).toString().replace("&nbsp;","").trim();
            String nohouseSaleableNumber = eles.get(5).childNode(0).toString().replace("&nbsp;","").trim();
            Project project = Project.builder().projectNo(projectNo).projectName(projectName).totalNumber(totalNumber).houseSaledNumber(houseSaledNumber).
                    houseSaleableNumber(houseSaleableNumber).nohouseSaledNumber(nohouseSaledNumber).nohouseSaleableNumber(nohouseSaleableNumber).build();
            projects.add(project);

        }
        return projects;
    }
    //获取项目下的楼栋
    public static List<Building> fetchBuilding(String projectNo){
        Document document = null;
        List<Building> result = new ArrayList<>();
        try {
            document =Jsoup.connect(BuildingPagePara.url+"?DengJh="+URLEncoder.encode(projectNo,"gb2312")).timeout(30000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = document.select("body > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table:nth-child(2) > tbody > tr > td > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(2) > td > table:nth-child(2) > tbody").get(0).getElementsByTag("tr");
        for(int i=2;i<elements.size();i++){
            Elements eles = elements.get(i).getElementsByTag("td");
            String buildingName = eles.get(0).childNode(1).childNode(1).childNode(0).toString();
            String buildingNo = eles.get(0).childNode(1).attr("href").split("=")[2];
            String buildingStructure = eles.get(1).childNode(0).toString().replace("&nbsp;","").trim();
            String totalFloor = eles.get(2).childNode(0).toString().replace("&nbsp;","").trim();
            String totalRoom = eles.get(3).childNode(0).toString().replace("&nbsp;","").trim();
            Building building= Building.builder().buildingName(buildingName).buildingNo(buildingNo).buildingStructure(buildingStructure).totalFloor(totalFloor).totalRoom(totalRoom).build();
            result.add(building);
        }
        return result;
    }

    public static List<Room> fetchRoom(String projectNo,String buildingNo){
        Document document = null;
        List<Room> result = new ArrayList<>();
        try {
            document =Jsoup.connect(RoomPagePara.url+"?DengJh="+URLEncoder.encode(projectNo,"gb2312")+"&HouseDengjh="+URLEncoder.encode(buildingNo,"gb2312")).timeout(30000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = document.select("body > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table:nth-child(2) > tbody > tr > td > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(2) > td > table:nth-child(4) > tbody > tr > td > table > tbody")
                .get(0).getElementsByTag("tr");
        for(int i=3;i<elements.size();i++){
            String buildingCode = elements.get(i).childNode(0).childNode(0).toString();
            String unit = elements.get(i).childNode(1).childNode(0).toString();
            String floor = elements.get(i).childNode(2).childNode(0).toString();
            for(int j=0;j<elements.get(i).childNodes().size()-3;j++){
                String gids;
                if(!StringUtils.isEmpty(elements.get(i).childNode(3+j).childNode(0).attr("href"))){
                    gids = elements.get(i).childNode(3+j).childNode(0).attr("href").split("=")[1];
                }else {
                    gids = "-";
                }

                Room room = Room.builder().buildingCode(buildingCode).unit(unit).floor(floor).gids(gids).build();
                result.add(room);
            }
        }

        return result;
    }

    public static Price fetchPrice(String gid){
        Document document = null;
        Price price = new Price();
        List<Room> result = new ArrayList<>();
        try {
            document =Jsoup.connect(PricePara.url+"?gid="+gid).timeout(30000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element elementSize = document.select("#form1 > div.container > table > tbody > tr:nth-child(3) > td:nth-child(3)").get(0);
        Element elementPrice = document.select("#form1 > div.container > table > tbody > tr:nth-child(5) > td:nth-child(3) > img").get(0);
        String size = elementSize.childNode(0).toString();
        String priceurl = elementPrice.attr("src");
        price.setCode(priceurl.split("=")[1]);
        return null;
    }


    public static void main(String[] args) {
        System.setProperty("http.proxyHost", "127.0.0.1");
        System.setProperty("https.proxyHost", "127.0.0.1");
        System.setProperty("http.proxyPort", "8888");
        System.setProperty("https.proxyPort", "8888");
        //5.asp?DengJh=洪1700673&HouseDengjh=洪0004242
        TessUtil.decode("/I1dJ21FnhuAyXT9QHSvzQ==");
    }
}
