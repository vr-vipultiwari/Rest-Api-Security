package com.spring.security.restappsecurity.model;


public class Student {
    private final Integer studentId;
    private final String name;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                '}';
    }

    public Student(Integer studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }


    public Integer getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

}
