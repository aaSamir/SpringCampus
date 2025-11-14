package com.samir.springcampus.controller;

import com.samir.springcampus.entity.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.samir.springcampus.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student){
        Student s = studentService.saveStudent(student);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    @GetMapping("/students")
    public ResponseEntity<Page<Student>> fetchAllStudent(
            @RequestParam(defaultValue = "0")int page_no,
            @RequestParam(defaultValue = "10")int page_size,
            @RequestParam(defaultValue = "name")String sort_by,
            @RequestParam(defaultValue = "asc")String sort_dir
    ){
        Page<Student> page =  studentService.fetchAllStudent(page_no,page_size,sort_by,sort_dir);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> fetchStudentById(@PathVariable("id") Long id){
        Student s = studentService.fetchStudentById(id);
        return ResponseEntity.ok(s);
    }

    @GetMapping("/students/name/{name}")
    public ResponseEntity<Optional<Student>> fetchStudentByName(@PathVariable("name") String name){
        Optional<Student> s = studentService.fetchStudentByName(name);
        return ResponseEntity.ok(s);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student deleted successfully");
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id")Long id, @Valid @RequestBody Student student){
        Student s = studentService.updateStudent(id, student);
        return ResponseEntity.ok(s);
    }

}
