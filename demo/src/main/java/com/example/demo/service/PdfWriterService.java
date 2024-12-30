package com.example.demo.service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;

import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfWriterService {

     public byte[] createPdf(){
         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

         try {
             PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);
             PdfDocument pdfDocument = new PdfDocument(pdfWriter);
             Document document = new Document(pdfDocument);

             Table table = new Table(3);


         } catch (Exception e) {
             throw new RuntimeException(e);
         }return  null;
     }
}
