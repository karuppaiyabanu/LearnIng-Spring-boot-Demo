package com.example.demo.dto;

public class FileResponseDTO {

    private byte[] fileContent;
    private int statusCode;
    private String message;

    public FileResponseDTO(byte[] fileContent, int statusCode, String message) {
        this.fileContent = fileContent;
        this.statusCode = statusCode;
        this.message = message;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
