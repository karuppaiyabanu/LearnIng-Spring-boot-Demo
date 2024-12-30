package com.example.demo.controller;


import com.example.demo.service.FileCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class FileController {

    @Autowired
    private FileCreateService fileCreateService;

    @GetMapping("/generate-file")
    public ResponseEntity<byte[]> generateFile(@RequestParam String filename) throws IOException {
        String content = fileCreateService.generateFileContent(filename);

        String fileName = "generated-file" + fileCreateService.getExtension(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .contentType(FileCreateService.getMediaType(filename))
                .body(content.getBytes());
    }

    @GetMapping("/")
    public ResponseEntity<byte[]> generateExcel() throws IOException {
        byte[] excelFile = fileCreateService.generateExcelFile();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=example.xls")
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(excelFile);
    }

    @GetMapping("/generate-pdf")
    public ResponseEntity<byte[]> generatePdf() throws IOException {
        byte[] pdfFile = fileCreateService.generatePdfFile();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=generated.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfFile);
    }
}

