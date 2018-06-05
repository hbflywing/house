package com.shawn.house;


import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by shawn.zeng on 2018/6/1.
 */
public class Test {
    public static void main(String[] args) throws TesseractException, UnsupportedEncodingException {
        /*File imageFile = new File("E:\\shawn_src\\house\\src\\main\\resources\\GetHouseInfo.jpg");
        ITesseract instance = new Tesseract();
        String result = instance.doOCR(imageFile);
        System.out.println(result);*/
        System.out.println(URLEncoder.encode("硚","gbk"));

    }
}
