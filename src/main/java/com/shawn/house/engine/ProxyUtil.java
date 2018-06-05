package com.shawn.house.engine;

import com.shawn.house.engine.common.Proxyer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shawn.zeng on 2018/6/5.
 */
public class ProxyUtil {
    List<Proxyer> proxyers = new ArrayList<>();

    public static String url = "http://www.66ip.cn/mo.php?sxb=&tqsl=10&port=&export=&ktip=&sxa=&submit=%CC%E1++%C8%A1&textarea=";

    public ProxyUtil() throws IOException {
        Document document = Jsoup.connect(url).timeout(3000).get();
        Elements elements = document.select("html body");
        System.out.println(elements.html());
    }

    public static void main(String[] args) throws IOException {
        new ProxyUtil();
    }
}
