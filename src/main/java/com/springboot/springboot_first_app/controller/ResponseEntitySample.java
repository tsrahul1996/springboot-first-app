package com.springboot.springboot_first_app.controller;

import com.springboot.springboot_first_app.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResponseEntitySample {

    @GetMapping("responseEntity/student")
    public ResponseEntity<Student> getStudent() {

        Student student = new Student(1, "Rahul", "Sivan");

        //return new ResponseEntity<>(student, HttpStatus.OK);
        //return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header", "Rahul").body(student);
    }

    @GetMapping("responseEntity/students")
    public ResponseEntity<List<Student>> getStudents() {

        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Rahul", "Sivan"));
        students.add(new Student(2, "Surag", "KS"));
        students.add(new Student(3, "Ron", "Grego"));
        students.add(new Student(3, "Rocco", "Wakeup"));

        return ResponseEntity.ok().body(students);

    }

    //Spring boot rest API with path variable
    // {id} - URI template variable
    @GetMapping("responseEntity/students/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                                       @PathVariable("first-name") String firstName,
                                                       @PathVariable("last-name") String lastName) {

        Student student = new Student(studentId, firstName, lastName);

        return ResponseEntity.ok().body(student);

    }

    //Spring boot rest API with Request Param
    //http://localhost:8080/students/query?id=1&firstName=Rahul&lastName=Sivan
    @GetMapping("responseEntity/students/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                                          @RequestParam String firstName,
                                                          @RequestParam String lastName) {
        // return (new Student(id,firstName,lastName));
        return ResponseEntity.ok().body(new Student(id, firstName, lastName));

    }

    //Spring boot rest API that handles HTTP POST Request  - creating existing resource
    // @PostMapping @RequestBody
    @PostMapping("responseEntity/students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {

        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //Spring boot rest API that handles HTTP PUT Request - updating existing resource
    @PutMapping("responseEntity/students/{id}/update")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int studentId, @RequestBody Student student) {


        student.setId(studentId);


        return ResponseEntity.ok().body(student);

    }


    //Spring boot rest API that handles delete Request
    @DeleteMapping("responseEntity/students/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return ResponseEntity.ok().body("student deleted");
    }
}
