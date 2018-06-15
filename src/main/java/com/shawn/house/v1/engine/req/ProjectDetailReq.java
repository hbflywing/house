package com.shawn.house.v1.engine.req;

import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by shawn.zeng on 2018/6/7.
 */
@Data
public class ProjectDetailReq {

    private Logger logger = LoggerFactory.getLogger(getClass());
    //post请求
    public static String url= "http://fgj.wuhan.gov.cn/zz_spfxmcx_mx.jspx";

    private String dengJh;

    public Document getDocument(){
        try {
            return Jsoup.connect(url).data("dengJh",dengJh).timeout(60*1000).get();
        } catch (IOException e) {
            logger.error("fetch building detail err! gid = "+dengJh);
            return null;
        }
    }
}
