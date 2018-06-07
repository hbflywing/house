package com.shawn.house.engine.req;

import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Data
public class RoomReq {
    public static final String url= "http://fgj.wuhan.gov.cn/zz_spfxmcx_fang.jspx";

    private String dengJh;

    private String houseDengJh;

    Document getDocument() throws IOException {
        if(StringUtils.isEmpty(dengJh)||StringUtils.isEmpty(houseDengJh)){
            return null;
        }else {
            Map<String,String> data = new HashMap<>();
            data.put("dengJh",dengJh);
            data.put("houseDengJh",houseDengJh);
            return Jsoup.connect(url).data(data).timeout(60*1000).get();
        }
    }
}
