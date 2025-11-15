package com.samir.springcampus.service;

import com.samir.springcampus.dto.StudentDTO;
import com.samir.springcampus.dto.StudentResponseDTO;
import org.springframework.data.domain.Page;


public interface StudentService {

    StudentResponseDTO saveStudent(StudentDTO studentDTO);

    Page<StudentResponseDTO> fetchAllStudent(int page_no, int page_size, String sort_by, String sort_dir);

    StudentResponseDTO fetchStudentById(Long id);

    void deleteStudentById(Long id);

    StudentResponseDTO updateStudent(Long id, StudentDTO studentDTO);

    StudentResponseDTO fetchStudentByName(String name);
}
