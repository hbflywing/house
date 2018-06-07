package com.shawn.house;

import com.shawn.house.engine.parse.ProjectParse;
import com.shawn.house.engine.req.ProjectReq;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shawn.zeng on 2018/6/7.
 */
public class TestProjectFetch {
    public static void main(String[] args) throws IOException {
        ProjectReq projectReq = new ProjectReq();
        Document document = projectReq.getDocument();
        ProjectParse.getPage(document);

        /*String str = "共 4843 条记录";
        Pattern p=Pattern.compile("共(.*?)条记录");
        Matcher m=p.matcher(str);
        while (m.find()){
            System.out.println(m.group(1).trim());
        }*/
    }
}
