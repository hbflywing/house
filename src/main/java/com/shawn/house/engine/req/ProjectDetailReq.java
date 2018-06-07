package com.shawn.house.engine.req;

import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by shawn.zeng on 2018/6/7.
 */
@Data
public class ProjectDetailReq {
    //post请求
    public static String url= "http://fgj.wuhan.gov.cn/zz_spfxmcx_mx.jspx";

    private String dengJh;

    public Document getDocument() throws IOException{
        return Jsoup.connect(url).data("dengJh",dengJh).timeout(60*1000).get();
    }
}
