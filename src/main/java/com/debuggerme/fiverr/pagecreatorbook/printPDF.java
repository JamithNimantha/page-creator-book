package com.debuggerme.fiverr.pagecreatorbook;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.PngImage;

import java.io.File;
import java.io.FileOutputStream;


public class printPDF {
    public static String y = "";

    public static void PngToPdf(String pngfilename) {
        try {
            Rectangle one = new Rectangle(MainMenu.pgWd, MainMenu.pgHd);
            Document convertPngToPdf = new Document();
            convertPngToPdf.setPageSize(one);
            convertPngToPdf.setMargins(0.0F, 0.0F, 0.0F, 0.0F);
            PdfWriter.getInstance(convertPngToPdf, new FileOutputStream(MainMenu.txtSaveFilePath));
            convertPngToPdf.open();
            Image convertBmp = PngImage.getImage(".tmp32/" + pngfilename);

            /*convertBmp.setAbsolutePosition(0, 0);
            float documentWidth = convertPngToPdf.getPageSize().getWidth() - convertPngToPdf.leftMargin() - convertPngToPdf.rightMargin();
            float documentHeight = convertPngToPdf.getPageSize().getHeight() - convertPngToPdf.topMargin() - convertPngToPdf.bottomMargin();
            convertBmp.scaleAbsolute(documentWidth, documentHeight);
            convertBmp.scaleAbsolute(convertPngToPdf.getPageSize().getWidth(), convertPngToPdf.getPageSize().getHeight());
            int indentation = 0;
            float scaler = ((convertPngToPdf.getPageSize().getWidth() - convertPngToPdf.leftMargin()
                    - convertPngToPdf.rightMargin() - indentation) / convertBmp.getWidth()) * 100;
            convertBmp.scalePercent(scaler);*/

            convertPngToPdf.add((Element) convertBmp);
            convertPngToPdf.close();
            System.out.println("Converted and stamped PNG Image in a PDF Document Using iText and Java");
        } catch (Exception i1) {
            i1.printStackTrace();
        }
    }

    public static void MultiPngToPdf(String pngfilename) {
        String x = "temp32/";
        y = x + MainMenu.txtSaveMultiFileName;
        File xx = new File(x);
        File yy = new File(y);
        if (xx.exists()) {
            if (!yy.exists()) {
                yy.mkdir();
            }
        } else {

            xx.mkdirs();
        }
        try {
            Rectangle one = new Rectangle(MainMenu.pgWd, MainMenu.pgHd);
            Document convertPngToPdf = new Document();
            convertPngToPdf.setPageSize(one);
            convertPngToPdf.setMargins(0.0F, 0.0F, 0.0F, 0.0F);
            PdfWriter.getInstance(convertPngToPdf, new FileOutputStream(y + "/" + pngfilename + ".pdf"));
            convertPngToPdf.open();
            Image convertBmp = PngImage.getImage(".tmp32/" + pngfilename + ".png");
            convertPngToPdf.add((Element) convertBmp);
            convertPngToPdf.close();
        } catch (Exception i1) {
            i1.printStackTrace();
        }
    }
}
