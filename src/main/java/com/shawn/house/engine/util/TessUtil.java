package com.shawn.house.engine.util;

import com.shawn.house.web.entity.RoomEntity;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.*;
import java.util.Base64;

public class TessUtil {
    private static ITesseract tesseract = new Tesseract();

    public static final String url="http://119.97.201.28:6081/GetHouseInfo.ashx?price=";

    private TessUtil(){}

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
            String str = tesseract.doOCR(file);
            roomEntity.setPriceString(str);
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return null;
    }

}
