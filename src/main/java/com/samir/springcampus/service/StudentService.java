package com.samir.springcampus.service;

import com.samir.springcampus.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public Student saveStudent(Student student);

    public List<Student> fetchAllStudent();

    public Student fetchStudentById(Long id);

    public void deleteStudentById(Long id);

    public Student updateStudent(Long id, Student student);

    public Optional<Student> fetchStudentByName(String name);
}
