package com.shawn.house.engine.req;

import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.util.StringUtils;
import java.io.IOException;


@Data
public class BuildingReq {
    public static final String url= "http://fgj.wuhan.gov.cn/zz_spfxmcx_loupan.jspx";

    private String dengJh;

    public Document getDocument() throws IOException{
        if(StringUtils.isEmpty(dengJh)){
            return null;
        }else{
            return Jsoup.connect(url).data("dengJh", dengJh).timeout(60*1000).get();
        }
    }

    public static void main(String[] args) throws IOException {
        System.setProperty("http.proxyHost", "127.0.0.1");
        System.setProperty("https.proxyHost", "127.0.0.1");
        System.setProperty("http.proxyPort", "8888");
        System.setProperty("https.proxyPort", "8888");
        BuildingReq buildingReq = new BuildingReq();
        buildingReq.setDengJh("黄1800294");
        buildingReq.getDocument();
    }

}
