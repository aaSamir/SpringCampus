package com.samir.springcampus.service;

import com.samir.springcampus.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;


import java.util.List;
import java.util.Optional;

public interface StudentService {

    public Student saveStudent(Student student);

    public Page<Student> fetchAllStudent(int page_no, int page_size, String sort_by, String sort_dir);

    public Student fetchStudentById(Long id);

    public void deleteStudentById(Long id);

    public Student updateStudent(Long id, Student student);

    public Optional<Student> fetchStudentByName(String name);
}
