package com.example.demo.controller;


import com.example.demo.dto.FileResponseDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/create")
    public User create(@ModelAttribute User user, @RequestParam("file") MultipartFile file) {
     try {
       return   userService.create(file,user);
     } catch (IOException e) {
         throw new RuntimeException(e);
     }

        //return this.userService.create(user);
    }

    @GetMapping("/")
    public List<User> retrieve() {
        return this.userService.retrieve();
    }

    @GetMapping("/{id}")
    public Optional<User> retrieveById(@PathVariable("id") Integer id) {
        return this.userService.retrieveById(id);
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable("id") Integer id, @RequestBody User user) {
        return this.userService.update(id, user);
    }

    @DeleteMapping("/remove/{id}")
    public String remove(@PathVariable("id")Integer id) {
        return this.userService.remove(id);
    }

    @GetMapping("/excel")
    public  void generateExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");

        String headerKey="Content-Disposition";
        String headerValue="attachment;filename=users.xls";

        response.setHeader(headerKey,headerValue);


       this.userService.generateExcelFile(response);
    }


    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> retrieveUserImage(@PathVariable("id") Integer id) {
        byte[] imageBytes = userService.getUserImage(id);

        if (imageBytes == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageBytes);
    }




    }
