package com.samir.springcampus.controller;

import com.samir.springcampus.entity.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.samir.springcampus.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public Student saveStudent(@Valid @RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/students")
    public List<Student> fetchAllStudent(){
        return studentService.fetchAllStudent();
    }

    @GetMapping("/students/{id}")
    public Student fetchStudentById(@PathVariable("id") Long id){
        return studentService.fetchStudentById(id);
    }

    @GetMapping("/students/name/{name}")
    public Optional<Student> fetchStudentByName(@PathVariable("name") String name){
        return studentService.fetchStudentByName(name);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudentById(@PathVariable("id") Long id){
        studentService.deleteStudentById(id);
        return "Student deleted successfully";
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable("id")Long id, @Valid @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

}
