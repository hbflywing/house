package com.shawn.house.engine.req;

import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Data
public class RoomReq {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public static final String url= "http://fgj.wuhan.gov.cn/zz_spfxmcx_fang.jspx";

    private String dengJh;

    private String houseDengJh;

    public Document getDocument(){
        if(StringUtils.isEmpty(dengJh)||StringUtils.isEmpty(houseDengJh)){
            return null;
        }else {
            Map<String,String> data = new HashMap<>();
            data.put("dengJh",dengJh);
            data.put("houseDengJh",houseDengJh);
            try {
                return Jsoup.connect(url).data(data).timeout(60*1000).get();
            } catch (IOException e) {
                logger.error("fetch room err! dengJh = "+dengJh+" houseDengJh = "+houseDengJh);
                return null;
            }
        }
    }
}
