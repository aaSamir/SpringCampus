package com.samir.springcampus.service;

import com.samir.springcampus.entity.Student;
import com.samir.springcampus.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;
import com.samir.springcampus.repository.StudentRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public Page<Student> fetchAllStudent(int page_no, int page_size, String sort_by, String sort_dir) {
        Sort sort = sort_dir.equalsIgnoreCase("asc")?Sort.by(sort_by).ascending():Sort.by(sort_by).descending();
        Pageable pageable = PageRequest.of(page_no, page_size, sort);
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student fetchStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()){
            throw new StudentNotFoundException("Student Not Found with ID "+id);
        }
        return student.get();
    }

    @Override
    public void deleteStudentById(Long id) {

        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()){
            throw new StudentNotFoundException("Student Not Found with ID "+id);
        }

        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Optional <Student> existingStudent = studentRepository.findById(id);

        if(existingStudent.isEmpty()){
            throw new StudentNotFoundException("Student Not Found with ID "+id);
        }

        Student updatedStudent = existingStudent.get();

        if(Objects.nonNull(student.getDeptName()) && !"".equalsIgnoreCase(student.getDeptName())){
            updatedStudent.setDeptName(student.getDeptName());
        }
        return studentRepository.save(updatedStudent);
    }

    @Override
    public Optional<Student> fetchStudentByName(String name) {
        return studentRepository.findByNameIgnoreCase(name);
    }
}
