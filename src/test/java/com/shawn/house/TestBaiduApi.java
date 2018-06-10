package com.shawn.house;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by shawn.zeng on 2018/6/9.
 */
public class TestBaiduApi {
    //设置APPID/AK/SK
    public static final String APP_ID = "11376229";
    public static final String API_KEY = "bvm1CTdcw6IbaKQP5scvXM7b";
    public static final String SECRET_KEY = "mqF8GhEcMMqCy0nrHY2L9wkMqSYRkEdv";
    public static void main(String[] args) throws JSONException {

// 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);


        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "E:\\temp\\MDBHZ3pHU2dOanlDbDZsL2hrRFRTUT09.jpg";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));
    }
}
