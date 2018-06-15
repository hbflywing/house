package com.shawn.house.v1.engine.util;

import com.baidu.aip.ocr.AipOcr;
import com.shawn.house.v1.web.dao.PriceJPA;
import com.shawn.house.v1.web.entity.PriceEntity;
import com.shawn.house.v1.web.entity.RoomEntity;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.io.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Optional;

/**
 * Created by shawn.zeng on 2018/6/9.
 */
public class BaiduApiUtil {
    public static final String url="http://119.97.201.28:6081/GetHouseInfo.ashx?price=";

    private static final String APP_ID = "11376229";
    private static final String API_KEY = "bvm1CTdcw6IbaKQP5scvXM7b";
    private static final String SECRET_KEY = "mqF8GhEcMMqCy0nrHY2L9wkMqSYRkEdv";

    public static String decode(RoomEntity roomEntity){
        try {
            Connection.Response response = Jsoup.connect(url+roomEntity.getPrice()).timeout(60*1000).execute();
            byte[] bytes = response.bodyAsBytes();
            roomEntity.setPriceByte(bytes);
            File file = new File("E:\\temp"+File.separator+ Base64.getEncoder().encodeToString(roomEntity.getPrice().getBytes())+".jpg");
            if(!file.exists()){
                file.createNewFile();
            }
            OutputStream output = new FileOutputStream(file);
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);
            bufferedOutput.write(bytes);
            bufferedOutput.flush();
            PriceJPA priceJPA = SpringUtil.getBean(PriceJPA.class);
            Optional<PriceEntity> priceEntity =  priceJPA.findOne(new Example<PriceEntity>() {
                @Override
                public PriceEntity getProbe() {
                    PriceEntity priceEntity = new PriceEntity();
                    priceEntity.setPrice(roomEntity.getPrice());
                    return priceEntity;
                }

                @Override
                public ExampleMatcher getMatcher() {
                    return ExampleMatcher.matching();
                }
            });
            if(priceEntity.isPresent()){
                roomEntity.setPriceString(priceEntity.get().getStringPrice());
            }else {
                AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
                // 可选：设置网络连接参数
                client.setConnectionTimeoutInMillis(2000);
                client.setSocketTimeoutInMillis(60000);
                // 调用接口
                JSONObject res = client.basicGeneral(bytes, new HashMap<String, String>());
                roomEntity.setPriceString(res.getJSONArray("words_result").getJSONObject(0).getString("words"));
                PriceEntity pe = new PriceEntity();
                pe.setPrice(roomEntity.getPrice());
                pe.setStringPrice(roomEntity.getPriceString());
                priceJPA.save(pe);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
