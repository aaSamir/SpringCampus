package com.samir.springcampus.controller;

import com.samir.springcampus.entity.Teacher;
import com.samir.springcampus.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public ResponseEntity<Teacher> saveTeacher(@Valid @RequestBody Teacher teacher){
        Teacher t = teacherService.saveTeacher(teacher);
        return new ResponseEntity<>(t, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Teacher>> fetchAllTeacher(
            @RequestParam(defaultValue = "0")int page_no,
            @RequestParam(defaultValue = "10")int page_size,
            @RequestParam(defaultValue = "name")String sort_by,
            @RequestParam(defaultValue = "asc")String sort_dir
    ){
        Page<Teacher> t = teacherService.fetchAllTeacher(page_no, page_size, sort_by, sort_dir);
        return ResponseEntity.ok(t);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> fetchTeacherById(@PathVariable("id") Long id){
        Teacher t = teacherService.fetchTeacherById(id);
        return ResponseEntity.ok(t);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTeacherById(@PathVariable("id") Long id){
        teacherService.deleteTeacherById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Teacher deleted successfully");
    }

    @PutMapping("{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable("id") Long id, @Valid @RequestBody Teacher teacher){
        Teacher t = teacherService.updateTeacher(id, teacher);
        return ResponseEntity.ok(t);
    }
}
