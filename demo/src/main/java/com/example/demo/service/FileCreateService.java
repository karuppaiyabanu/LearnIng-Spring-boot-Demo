package com.example.demo.service;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class FileCreateService {

    public static MediaType getMediaType(String filename) {
        if (filename.endsWith(".html")) {
            return MediaType.TEXT_HTML;
        } else if (filename.endsWith(".css")) {
            return MediaType.valueOf("text/css");
        } else if (filename.endsWith(".java")) {
            return MediaType.valueOf("text/java");
        } else if (filename.endsWith(".pdf")) {
            return MediaType.valueOf("text/pdf");
        } else if (filename.endsWith(".xls")) {
            return MediaType.valueOf(".xls");
        } else {
            return MediaType.TEXT_PLAIN;
        }
    }

    //create pdf
    public String getExtension(String filename) {
        if (filename.endsWith(".txt")) {
            return ".txt";
        } else if (filename.endsWith(".html")) {
            return ".html";
        } else if (filename.endsWith(".css")) {
            return ".css";
        } else if (filename.endsWith(".java")) {
            return ".java";
        } else if (filename.endsWith(".pdf")) {
            return ".pdf";
        } else if (filename.endsWith(".xls")) {
            return ".xls";
        }
        return ".txt";
    }

    public String generateFileContent(String filename) {
        return "Welcome";
    }
//-----------------------------------------------------------------------------------------
    public byte[] generateExcelFile() throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet 1");

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);
        workbook.close();

        return byteArrayOutputStream.toByteArray();
    }
    //----------------------------------------------------
    public  byte[] generatePdfFile() throws  IOException{

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

       // PdfWriter writer = new PdfWriter(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

}