package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "1"),
            new Student(2, "2"),
            new Student(3, "3"),
            new Student(4, "4")
    );

    @GetMapping(path = "{id}")
    public Student getStudent(@PathVariable Integer id) {
        return STUDENTS.stream()
                .filter(s -> id.equals(s.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Student %s does not exist.", id)));
    }
}
