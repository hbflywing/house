package com.shawn.house.engine.req;

import com.shawn.house.engine.util.StrUtils;
import lombok.Data;
import lombok.ToString;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询房价首页参数
 * Created by shawn.zeng on 2018/6/1.
 */

@Data
@ToString
public class ProjectReq {
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

    public Document getDocument() throws IOException {
        Map<String,String> hashMap = new HashMap();
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
        return Jsoup.connect(url).data(hashMap).timeout(60*1000).post();
    }

}
