package com.springboot.springboot_first_app.controller;

import com.springboot.springboot_first_app.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    //http://localhost:8080/student

    @GetMapping("student")
    public Student getStudent(){

        Student student = new Student(1,"Rahul","Sivan");

        return student;
    }

}
