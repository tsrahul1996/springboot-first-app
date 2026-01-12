package com.springboot.springboot_first_app.controller;

import com.springboot.springboot_first_app.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    //http://localhost:8080/student

    @GetMapping("student")
    public Student getStudent(){

        Student student = new Student(1,"Rahul","Sivan");

        return student;
    }
    @GetMapping("students")
    public List<Student> getStudents(){

        List<Student> students = new ArrayList<>();

        students.add(new Student(1,"Rahul","Sivan"));
        students.add(new Student(2,"Surag","KS"));
        students.add(new Student(3,"Ron","Grego"));
        students.add(new Student(3,"Rocco","Wakeup"));

        return students;
    }

    //Spring boot rest API with path variable
    // {id} - URI template variable
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){

        return new Student( studentId , firstName, lastName);

    }

}
