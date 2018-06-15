package com.shawn.house.v1.engine.req;

import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import java.io.IOException;


@Data
public class BuildingReq {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public static final String url= "http://fgj.wuhan.gov.cn/zz_spfxmcx_loupan.jspx";

    private String dengJh;

    public Document getDocument(){
        if(StringUtils.isEmpty(dengJh)){
            return null;
        }else{
            try {
                return Jsoup.connect(url).data("dengJh", dengJh).timeout(60*1000).get();
            } catch (IOException e) {
                logger.error("fetch building err! dengJh = "+dengJh);
                return null;
            }
        }
    }

}
