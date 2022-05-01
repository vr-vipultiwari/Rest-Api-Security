package com.spring.security.restappsecurity.controller;

import com.spring.security.restappsecurity.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS   = Arrays.asList(
        new Student(1 , "James Bond")   ,
        new Student(2,"Micheal jordan")    ,
        new Student(3 , "shane warn") ,
        new Student(4, " Krish Sharma")
    )  ;
    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable("studentId") Integer studentId) {

        return  STUDENTS.stream().filter(student -> student.getStudentId()==studentId )
                 .findFirst().orElseThrow(()-> new IllegalArgumentException("student with id: "+studentId+ " not exists") ) ;
    }
}
