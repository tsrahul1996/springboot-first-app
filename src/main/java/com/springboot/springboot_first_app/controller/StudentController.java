package com.springboot.springboot_first_app.controller;

import com.springboot.springboot_first_app.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    //http://localhost:8080/student

    @GetMapping("student")
    public Student getStudent(){

        Student student = new Student(1,"Rahul","Sivan");

        return student;
    }
    @GetMapping("")
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
    @GetMapping("{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){

        return new Student( studentId , firstName, lastName);

    }

    //Spring boot rest API with Request Param
    //http://localhost:8080/students/query?id=1&firstName=Rahul&lastName=Sivan
    @GetMapping("query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return(new Student(id,firstName,lastName));
    }

    //Spring boot rest API that handles HTTP POST Request  - creating existing resource
    // @PostMapping @RequestBody
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){

        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return student;
    }

    //Spring boot rest API that handles HTTP PUT Request - updating existing resource
    @PutMapping("{id}/update")
    public Student updateStudent(@PathVariable("id") int studentId,@RequestBody Student student){


        student.setId(studentId);
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return student;

    }


    //Spring boot rest API that handles delete Request
    @DeleteMapping("{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);

        return "Student deleted successfully!";
    }
}
