package com.samir.springcampus.controller;

import com.samir.springcampus.dto.TeacherDTO;
import com.samir.springcampus.dto.TeacherResponseDTO;
import com.samir.springcampus.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherResponseDTO> saveTeacher(@Valid @RequestBody TeacherDTO teacherDTO){
        TeacherResponseDTO teacherResponseDTO = teacherService.saveTeacher(teacherDTO);
        return new ResponseEntity<>(teacherResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<TeacherResponseDTO>> fetchAllTeacher(
            @RequestParam(defaultValue = "0")int page_no,
            @RequestParam(defaultValue = "10")int page_size,
            @RequestParam(defaultValue = "name")String sort_by,
            @RequestParam(defaultValue = "asc")String sort_dir
    ){
        Page<TeacherResponseDTO> teacherResponseDTOS = teacherService.fetchAllTeacher(page_no, page_size, sort_by, sort_dir);
        return ResponseEntity.ok(teacherResponseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponseDTO> fetchTeacherById(@PathVariable("id") Long id){
        TeacherResponseDTO teacherResponseDTO = teacherService.fetchTeacherById(id);
        return ResponseEntity.ok(teacherResponseDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTeacherById(@PathVariable("id") Long id){
        teacherService.deleteTeacherById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Teacher deleted successfully");
    }

    @PutMapping("{id}")
    public ResponseEntity<TeacherResponseDTO> updateTeacher(@PathVariable("id") Long id, @Valid @RequestBody TeacherDTO teacherDTO){
        TeacherResponseDTO teacherResponseDTO = teacherService.updateTeacher(id, teacherDTO);
        return ResponseEntity.ok(teacherResponseDTO);
    }
}
