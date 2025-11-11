package com.samir.springcampus.service;
import com.samir.springcampus.entity.Teacher;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    public Teacher saveTeacher(@Valid Teacher teacher);

    public List<Teacher> fetchAllTeacher();

    public Teacher fetchTeacherById(Long id);

    public void deleteTeacherById(Long id);

    public Teacher updateTeacher(Long id, @Valid Teacher teacher);
}
