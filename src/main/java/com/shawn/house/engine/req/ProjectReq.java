package com.shawn.house.engine.req;

import com.shawn.house.engine.util.StrUtils;
import lombok.Data;
import lombok.ToString;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询房价首页参数
 * Created by shawn.zeng on 2018/6/1.
 */

@Data
@ToString
public class ProjectReq {

    private Logger logger = LoggerFactory.getLogger(getClass());
    //post请求
    public static String url= "http://fgj.wuhan.gov.cn/zz_spfxmcx_index.jspx";
    //行政区域
    private String shiqs;
    //项目名称
    private String xiangMmc;
    //项目地址
    private String menPhm;
    //开发商
    private String kaifs;
    //当前页数
    private String pageNo;

    public Document getDocument(Proxy proxy){
        Map<String,String> hashMap = new HashMap<>();
        if(!StrUtils.isEmpty(shiqs)){
            hashMap.put("shiqs",shiqs);
        }
        if(!StrUtils.isEmpty(xiangMmc)){
            hashMap.put("xiangMmc",xiangMmc);
        }
        if(!StrUtils.isEmpty(kaifs)){
            hashMap.put("kaifs",kaifs);
        }
        if(!StrUtils.isEmpty(menPhm)){
            hashMap.put("menPhm",menPhm);
        }
        if(!StrUtils.isEmpty(pageNo)){
            hashMap.put("pageNo",pageNo);
        }
        if(proxy != null){
            try {
                return Jsoup.connect(url).data(hashMap).proxy(proxy).timeout(60*1000).post();
            } catch (IOException e) {
                logger.error("fetch project err! page = "+pageNo);
                return null;
            }
        }
        try {
            return Jsoup.connect(url).data(hashMap).timeout(60*1000).post();
        } catch (IOException e) {
            logger.error("fetch project err! page = "+pageNo);
            return null;
        }
    }
}
