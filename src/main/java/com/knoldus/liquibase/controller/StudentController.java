package com.knoldus.liquibase.controller;

import com.knoldus.liquibase.entity.Student;
import com.knoldus.liquibase.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("student")
    public String createStudent(@RequestParam String name) {
        studentRepository.save(new Student(name, " AKTU University"));
        String nameToReturn = studentRepository.findByName(name);
        return studentRepository.findByName(name) + " Saved successfully";
    }

    @GetMapping("student")
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

}

