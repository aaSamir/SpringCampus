package com.samir.springcampus.controller;

import com.samir.springcampus.dto.StudentDTO;
import com.samir.springcampus.dto.StudentResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.samir.springcampus.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<StudentResponseDTO> saveStudent(@Valid @RequestBody StudentDTO studentDTO){
        StudentResponseDTO studentResponseDTO = studentService.saveStudent(studentDTO);
        return new ResponseEntity<>(studentResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/students")
    public ResponseEntity<Page<StudentResponseDTO>> fetchAllStudent(
            @RequestParam(defaultValue = "0")int page_no,
            @RequestParam(defaultValue = "10")int page_size,
            @RequestParam(defaultValue = "name")String sort_by,
            @RequestParam(defaultValue = "asc")String sort_dir
    ){
        Page<StudentResponseDTO> studentResponseDTOS =  studentService.fetchAllStudent(page_no,page_size,sort_by,sort_dir);
        return ResponseEntity.ok(studentResponseDTOS);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentResponseDTO> fetchStudentById(@PathVariable("id") Long id){
        StudentResponseDTO studentResponseDTO = studentService.fetchStudentById(id);
        return ResponseEntity.ok(studentResponseDTO);
    }

    @GetMapping("/students/name/{name}")
    public ResponseEntity<StudentResponseDTO> fetchStudentByName(@PathVariable("name") String name){
        StudentResponseDTO studentResponseDTO = studentService.fetchStudentByName(name);
        return ResponseEntity.ok(studentResponseDTO);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student deleted successfully");
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable("id")Long id, @Valid @RequestBody StudentDTO studentDTO){
        StudentResponseDTO studentResponseDTO = studentService.updateStudent(id, studentDTO);
        return ResponseEntity.ok(studentResponseDTO);
    }

}
