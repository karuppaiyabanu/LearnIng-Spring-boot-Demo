package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity    // when you use @Entity Spring Automatically create the table using user ClassName,
@Table(name = "user")// you need to be modify the table name you can use @Table Annotation
public class User {

    @Id   //its on primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)// what type to genarate you ccan use that stratagy
    private Integer id;

    //@Column(name = "name")
    //when you use @Column Spring Automatically create the table colum_name  using @Column youcan modify it.
    private String name;

    private String phoneNumber;
    //@Column(name = "add")
    private String address;

    private String fileName;

    @Lob
    private byte[] fileData;

    private String fileType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
