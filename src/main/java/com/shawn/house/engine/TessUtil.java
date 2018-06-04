package com.shawn.house.engine;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;

public class TessUtil {
    private static ITesseract tesseract = new Tesseract();

    public static final String url="http://202.103.39.36/GetHouseInfo.ashx?price=";

    private TessUtil(){}

    public static String decode(String code){
        try {
            Connection.Response response = Jsoup.connect(url+code).execute();
            byte[] bytes = response.bodyAsBytes();
            File file = new File("E:\\temp"+File.separator+ Base64.getEncoder().encodeToString(code.getBytes())+".jpg");
            if(!file.exists()){
                file.createNewFile();
            }
            OutputStream output = new FileOutputStream(file);
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);
            bufferedOutput.write(bytes);
            bufferedOutput.flush();
            String str = tesseract.doOCR(file);
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return null;
    }

}
