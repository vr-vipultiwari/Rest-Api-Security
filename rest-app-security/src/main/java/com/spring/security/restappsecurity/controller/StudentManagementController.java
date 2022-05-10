package com.spring.security.restappsecurity.controller;


import com.spring.security.restappsecurity.model.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS   = Arrays.asList(
            new Student(1 , "James Bond")   ,
            new Student(2,"Micheal jordan")    ,
            new Student(3 , "shane warn") ,
            new Student(4, " Krish Sharma")
    )  ;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMINTRAINEE','ROLE_ADMIN')")
    public List<Student> getAllStudents() {
        return STUDENTS ;
    }


    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student) {
       // STUDENTS.add(student);
        System.out.println("registerNewStudent :" + student);
    }

    @DeleteMapping("/{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println("deleteStudent" + studentId);
    }


    @PutMapping(path="/{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(Integer studentId , Student student) {

        System.out.println(String.format(" updateStudent :  %s  %s ",studentId,student));
    }
}
