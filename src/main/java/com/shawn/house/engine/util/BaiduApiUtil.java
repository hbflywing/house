package com.shawn.house.engine.util;

import com.baidu.aip.ocr.AipOcr;
import com.shawn.house.web.entity.RoomEntity;
import net.sourceforge.tess4j.TesseractException;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.*;
import java.util.Base64;
import java.util.HashMap;

/**
 * Created by shawn.zeng on 2018/6/9.
 */
public class BaiduApiUtil {

    public static final String url="http://119.97.201.28:6081/GetHouseInfo.ashx?price=";

    public static final String APP_ID = "11376229";
    public static final String API_KEY = "bvm1CTdcw6IbaKQP5scvXM7b";
    public static final String SECRET_KEY = "mqF8GhEcMMqCy0nrHY2L9wkMqSYRkEdv";

    public static String decode(RoomEntity roomEntity){
        try {
            Connection.Response response = Jsoup.connect(url+roomEntity.getPrice()).execute();
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

            AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

            // 可选：设置网络连接参数
            client.setConnectionTimeoutInMillis(2000);
            client.setSocketTimeoutInMillis(60000);

            // 调用接口
            JSONObject res = client.basicGeneral(bytes, new HashMap<String, String>());
            roomEntity.setPriceString(res.getJSONArray("words_result").getJSONObject(0).getString("words"));
            System.out.println(res.toString(2));
            return res.toString(2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
