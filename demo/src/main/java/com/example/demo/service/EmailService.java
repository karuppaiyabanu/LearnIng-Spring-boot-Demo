package com.example.demo.service;

import com.example.demo.repository.SchoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private SchoolRepo schoolRepo;

    public  String[] getEmail(){
        return  this.schoolRepo.get();
    }

}
