package com.samir.springcampus.controller;

import com.samir.springcampus.dto.StudentDTO;
import com.samir.springcampus.dto.StudentResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.samir.springcampus.service.StudentService;

@RestController
@RequestMapping("/students")
@Tag(name = "Student Controller", description = "Endpoints for managing student operations")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Operation(summary = "Save new Student", description = "Creates a new student using StudentDTO")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Student successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid request body")
    })
    @PostMapping
    public ResponseEntity<StudentResponseDTO> saveStudent(@Valid @RequestBody StudentDTO studentDTO){
        StudentResponseDTO studentResponseDTO = studentService.saveStudent(studentDTO);
        return new ResponseEntity<>(studentResponseDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Get all students", description = "Pagination+Sorting supported")
    @GetMapping
    public ResponseEntity<Page<StudentResponseDTO>> fetchAllStudent(
            @RequestParam(defaultValue = "0")int page_no,
            @RequestParam(defaultValue = "10")int page_size,
            @RequestParam(defaultValue = "name")String sort_by,
            @RequestParam(defaultValue = "asc")String sort_dir
    ){
        Page<StudentResponseDTO> studentResponseDTOS =  studentService.fetchAllStudent(page_no,page_size,sort_by,sort_dir);
        return ResponseEntity.ok(studentResponseDTOS);
    }

    @Operation(summary = "Get student by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Student found"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> fetchStudentById(@PathVariable("id") Long id){
        StudentResponseDTO studentResponseDTO = studentService.fetchStudentById(id);
        return ResponseEntity.ok(studentResponseDTO);
    }

    @Operation(summary = "Get student by name")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Student found"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/name/{name}")
    public ResponseEntity<StudentResponseDTO> fetchStudentByName(@PathVariable("name") String name){
        StudentResponseDTO studentResponseDTO = studentService.fetchStudentByName(name);
        return ResponseEntity.ok(studentResponseDTO);
    }

    @Operation(summary = "Delete student by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Student deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student deleted successfully");
    }

    @Operation(summary = "Update student by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Student updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable("id")Long id, @Valid @RequestBody StudentDTO studentDTO){
        StudentResponseDTO studentResponseDTO = studentService.updateStudent(id, studentDTO);
        return ResponseEntity.ok(studentResponseDTO);
    }

}
