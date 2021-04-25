package net.chanrich.fileconverter.utils;

import org.docx4j.Docx4J;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author: Effort
 * @date: 2021-04-21
 * @time: 10:47 下午
 * @description:
 */
public class WordUtils {
    public boolean wordToPdf(File wordFile,File pdfFile){
         try {
             WordprocessingMLPackage wordPackage = WordprocessingMLPackage
                     .load(wordFile);
             Docx4J.toPDF(wordPackage, new FileOutputStream(pdfFile));
            return true;
         } catch (Docx4JException | FileNotFoundException e) {
            e.printStackTrace();
        }
         return false;
    }
}
