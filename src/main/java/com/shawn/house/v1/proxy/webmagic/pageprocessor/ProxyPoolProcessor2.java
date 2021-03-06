package com.shawn.house.v1.proxy.webmagic.pageprocessor;

import com.shawn.house.v1.proxy.domain.IpPoolEntity;
import com.shawn.house.v1.proxy.utils.UserAgentUtil;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CrowHawk on 17/10/16.
 */
public class ProxyPoolProcessor2 implements PageProcessor {

    private Site site = Site.me().setDisableCookieManagement(true)
            .setTimeOut(6000).setRetryTimes(3)
            .setSleepTime(1000)
            .setCharset("UTF-8")
            .addHeader("Accept-Encoding", "/")
            .setUserAgent(UserAgentUtil.getRandomUserAgent());

    @Override
    public void process(Page page) {
        List<String> ipList = page.getHtml().xpath("//table[@class='table table-bordered table-striped']/tbody/tr").all();
        List<IpPoolEntity> result = new ArrayList<>();

        if(ipList != null && ipList.size() > 0){
            for(String tmp : ipList){
                Html html = Html.create(tmp);
                IpPoolEntity proxyIp = new IpPoolEntity();
                String[] data = html.xpath("//body/text()").toString().trim().split("\\s+");

                proxyIp.setIp(data[0]);
                proxyIp.setPort(Integer.valueOf(data[1]));

                result.add(proxyIp);
            }
        }
        page.putField("result", result);
        page.addTargetRequest("http://www.kuaidaili.com/free/inha/2/");
        page.addTargetRequest("http://www.kuaidaili.com/free/intr/1/");
    }

    @Override
    public Site getSite() {
        return site;
    }
}
