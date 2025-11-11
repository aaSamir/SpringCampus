package com.samir.springcampus.controller;

import com.samir.springcampus.entity.Teacher;
import com.samir.springcampus.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public Teacher saveTeacher(@Valid @RequestBody Teacher teacher){
        return teacherService.saveTeacher(teacher);
    }

    @GetMapping
    public List<Teacher> fetchAllTeacher(){
        return teacherService.fetchAllTeacher();
    }

    @GetMapping("/{id}")
    public Teacher fetchTeacherById(@PathVariable("id") Long id){
        return teacherService.fetchTeacherById(id);
    }

    @DeleteMapping("{id}")
    public String deleteTeacherById(@PathVariable("id") Long id){
        teacherService.deleteTeacherById(id);
        return "Teacher deleted successfully";
    }

    @PutMapping("{id}")
    public Teacher updateTeacher(@PathVariable("id") Long id, @Valid @RequestBody Teacher teacher){
        return teacherService.updateTeacher(id, teacher);
    }
}
