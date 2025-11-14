package com.samir.springcampus.service;
import com.samir.springcampus.entity.Teacher;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;


import java.util.List;
import java.util.Optional;

public interface TeacherService {
    public Teacher saveTeacher(@Valid Teacher teacher);

    public Page<Teacher> fetchAllTeacher(int page_no, int page_size, String sort_by, String sort_name);

    public Teacher fetchTeacherById(Long id);

    public void deleteTeacherById(Long id);

    public Teacher updateTeacher(Long id, @Valid Teacher teacher);
}
