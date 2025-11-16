package com.samir.springcampus.service;

import com.samir.springcampus.dto.DepartmentDTO;
import com.samir.springcampus.dto.DepartmentResponseDTO;
import com.samir.springcampus.entity.Department;
import com.samir.springcampus.repository.DepartmentRepository;
import com.samir.springcampus.exception.DepartmentNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DepartmentResponseDTO saveDepartment(DepartmentDTO departmentDTO) {
        Department department = modelMapper.map(departmentDTO, Department.class);
        Department saved_department = departmentRepository.save(department);
        return modelMapper.map(saved_department, DepartmentResponseDTO.class);
    }

    @Override
    public Page<DepartmentResponseDTO> findAllDepartment(int page_no, int page_size, String sort_by, String sort_dir) {
        Sort sort = sort_dir.equalsIgnoreCase("asc")?Sort.by(sort_by).ascending():Sort.by(sort_by).descending();
        Pageable pageable = PageRequest.of(page_no, page_size, sort);
        Page<Department> department_page = departmentRepository.findAll(pageable);
        return department_page.map(department->modelMapper.map(department, DepartmentResponseDTO.class));
    }

    @Override
    public DepartmentResponseDTO findDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(()-> new DepartmentNotFoundException("Department Not Found with id "+id));
        return modelMapper.map(department, DepartmentResponseDTO.class);
    }

    @Override
    public DepartmentResponseDTO updateDepartment(Long id, DepartmentDTO departmentDTO) {
        Department existing_department = departmentRepository.findById(id).orElseThrow(()-> new DepartmentNotFoundException("Department Not Found with id "+id));

        existing_department.setName(departmentDTO.getName());
        existing_department.setTotal_student(departmentDTO.getTotal_student());
        existing_department.setTotal_teacher(departmentDTO.getTotal_teacher());

        Department updated_department = departmentRepository.save(existing_department);
        return modelMapper.map(updated_department, DepartmentResponseDTO.class);
    }

    @Override
    public void deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(()-> new DepartmentNotFoundException("Department Not Found with id "+id));
        departmentRepository.deleteById(id);
    }
}
