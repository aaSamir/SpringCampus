package com.samir.springcampus.service;

import com.samir.springcampus.entity.Student;
import com.samir.springcampus.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Student> fetchAllStudent() {
        return studentRepository.findAll();
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
