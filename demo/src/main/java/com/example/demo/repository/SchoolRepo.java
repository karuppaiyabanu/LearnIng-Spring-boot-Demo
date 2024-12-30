package com.example.demo.repository;

import com.example.demo.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SchoolRepo extends JpaRepository<School, String> {

    @Query(value = "select email from school", nativeQuery = true)
    String[] get();
}
