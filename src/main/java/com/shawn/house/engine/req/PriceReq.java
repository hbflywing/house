package com.shawn.house.engine.req;

import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import java.io.IOException;

/**
 * Created by shawn.zeng on 2018/6/4.
 */
@Data
public class PriceReq {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public static final String url= "http://119.97.201.28:6081/chktest2.aspx";

    private String gid;

    public Document getDocument() {
        if(StringUtils.isEmpty(gid)){
            return null;
        }else {
            try {
                return Jsoup.connect(url).data("gid",gid).timeout(60*1000).get();
            } catch (IOException e) {
                logger.error("fetch price code err! gid = "+gid);
                return null;
            }
        }
    }
}
