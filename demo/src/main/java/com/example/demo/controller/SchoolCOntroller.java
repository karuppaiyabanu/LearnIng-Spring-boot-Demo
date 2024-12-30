package com.example.demo.controller;

import com.example.demo.model.School;
import com.example.demo.repository.SchoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SchoolCOntroller {

    @Autowired
    private SchoolRepo schoolRepo;

    @PostMapping("/")
    public School create(@RequestBody School school){
        System.out.println(school);
        School s=new School();
        s.setName(school.getName());
        s.setEmail(school.getEmail());
        return  this.schoolRepo.save(s);
    }

    @GetMapping("/")
    public  String[] get(){
        String [] array=this.schoolRepo.get();
        return this.schoolRepo.get();
    }
}
