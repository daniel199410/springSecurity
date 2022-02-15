package com.example.demo.student;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "1"),
            new Student(2, "2"),
            new Student(3, "3"),
            new Student(4, "4")
    );

    @GetMapping
    public List<Student> getStudents() {
        return STUDENTS;
    }

    @PostMapping
    public void createStudent(@RequestBody Student student) {
        System.out.println(student);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("id") Integer id) {
        System.out.println(id);
    }

    @PutMapping(path = "{id}")
    public void updateStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
        System.out.printf("%s %s", id, student);
    }
}
