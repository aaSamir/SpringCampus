package com.samir.springcampus.service;


import com.samir.springcampus.dto.DepartmentDTO;
import com.samir.springcampus.dto.DepartmentResponseDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;

public interface DepartmentService {
    DepartmentResponseDTO saveDepartment(@Valid DepartmentDTO departmentDTO);

    Page<DepartmentResponseDTO> findAllDepartment(int page_no, int page_size, String sort_by, String sort_dir);

    DepartmentResponseDTO findDepartmentById(Long id);

    DepartmentResponseDTO updateDepartment(Long id, @Valid DepartmentDTO departmentDTO);

    void deleteDepartment(Long id);
}
