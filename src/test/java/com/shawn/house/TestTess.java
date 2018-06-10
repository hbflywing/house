package com.shawn.house;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * Created by shawn.zeng on 2018/6/9.
 */
public class TestTess {

    public static void main(String[] args) throws TesseractException {
        ITesseract tesseract = new Tesseract();
        File file = new File("E:\\temp\\NTNUUzVHdEVJME1rcXJ0QkxHeUhsdz09.jpg");
        String str = tesseract.doOCR(file);
        System.out.println(str);
    }
}
