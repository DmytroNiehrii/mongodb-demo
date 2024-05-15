package org.example.mongodbdemo.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.mongodbdemo.model.Student;
import org.example.mongodbdemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class StudentController {
    StudentService studentService;

    @GetMapping
    ResponseEntity<List<Student>> fetchAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @DeleteMapping
    void deleteStudent(@RequestParam String id) {
        studentService.deleteById(id);
//        return new ResponseEntity(HttpStatus.OK);
    }
}
