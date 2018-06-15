package com.shawn.house.v1.proxy.webmagic.pipeline;

import com.shawn.house.v1.proxy.domain.IpPoolEntity;
import com.shawn.house.v1.proxy.domain.IpPoolJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;
import java.util.Map;

/**
 * Created by CrowHawk on 17/10/16.
 */
@Component("IPSpiderPipeline")
public class IPSpiderPipeline implements Pipeline {

    @Autowired
    IpPoolJPA proxyIpMapper;

    @Override
    public void process(ResultItems resultItems, Task task) {
        for(Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            if (entry.getKey().equals("result")) {
                List<IpPoolEntity> ipList = (List<IpPoolEntity>) entry.getValue();
                for(IpPoolEntity proxyIp: ipList) {
                    proxyIpMapper.save(proxyIp);
                }
            }
        }
    }
}
