package com.example.demo.service;

import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User create(MultipartFile file, User user) throws IOException {
        User userObj = new User();
        userObj.setName(user.getName());
        userObj.setPhoneNumber(user.getPhoneNumber());
        userObj.setAddress(user.getAddress());

        userObj.setFileName(file.getOriginalFilename());
        userObj.setFileData(file.getBytes());
        userObj.setFileType(file.getContentType());

        return this.repository.save(userObj);
    }


    public Optional<User> retrieveById(Integer id) {
        return this.repository.findById(id);
    }

    public List<User> retrieve() {
        return this.repository.findAll();
    }

    public User update(Integer id, User user) {
        User userObj = this.repository.findById(id).orElseThrow();
        if (user.getAddress() != null) {
            userObj.setAddress(user.getAddress());
        }
        if (user.getName() != null) {
            userObj.setName(user.getName());
        }
        if (user.getPhoneNumber() != null) {
            userObj.setPhoneNumber(userObj.getPhoneNumber());
        }
        return this.repository.save(userObj);
    }

    public String remove(Integer id) {
        User user = this.repository.findById(id).orElseThrow();
        return "deleted SuccesFully";
    }


    public UserResponseDTO getUserWithImage(Integer id) {
        Optional<User> userObj = repository.findById(id);
        if (userObj.isPresent()) {
            User user = userObj.get();
            UserResponseDTO response = new UserResponseDTO();
            response.setFileData(user.getFileData());
            return response;
        }
        return null;
    }

    public byte[] getUserImage(Integer id) {
        User user = repository.findById(id).orElse(null);

        if (user == null || user.getFileData() == null) {
            return null;
        }
        return user.getFileData();
    }

    public void generateExcelFile(HttpServletResponse response) throws IOException {
        List<User> users = this.repository.findAll();

        //create a Work book

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("UserDetails info");
        HSSFRow row = sheet.createRow(0);

        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("NAME");
        row.createCell(2).setCellValue("PHONE_NUMBER");
        row.createCell(3).setCellValue("ADDRESS");

        int dataRowIndex = 1;

        for (User user : users) {
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(user.getId());
            dataRow.createCell(1).setCellValue(user.getName());
            dataRow.createCell(2).setCellValue(user.getPhoneNumber());
            dataRow.createCell(3).setCellValue(user.getAddress());

            dataRowIndex++;
        }
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        ;
        outputStream.close();
    }

    public void generatePdfFile(){

    }
}
