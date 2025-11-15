package com.samir.springcampus.service;
import com.samir.springcampus.dto.TeacherDTO;
import com.samir.springcampus.dto.TeacherResponseDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;

public interface TeacherService {
    TeacherResponseDTO saveTeacher(@Valid TeacherDTO teacherDTO);

    Page<TeacherResponseDTO> fetchAllTeacher(int page_no, int page_size, String sort_by, String sort_name);

    TeacherResponseDTO fetchTeacherById(Long id);

    void deleteTeacherById(Long id);

    TeacherResponseDTO updateTeacher(Long id, @Valid TeacherDTO teacherDTO);
}
