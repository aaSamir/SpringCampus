package com.samir.springcampus.service;

import com.samir.springcampus.dto.StudentDTO;
import com.samir.springcampus.dto.StudentResponseDTO;
import com.samir.springcampus.entity.Student;
import com.samir.springcampus.exception.StudentNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;
import com.samir.springcampus.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public StudentResponseDTO saveStudent(StudentDTO studentDTO){
        Student student = modelMapper.map(studentDTO, Student.class);
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentResponseDTO.class);

    }

    @Override
    public Page<StudentResponseDTO> fetchAllStudent(int page_no, int page_size, String sort_by, String sort_dir) {
        Sort sort = sort_dir.equalsIgnoreCase("asc")?Sort.by(sort_by).ascending():Sort.by(sort_by).descending();
        Pageable pageable = PageRequest.of(page_no, page_size, sort);
        Page<Student> studentPage = studentRepository.findAll(pageable);
        return studentPage.map(student -> modelMapper.map(student, StudentResponseDTO.class));
    }

    @Override
    public StudentResponseDTO fetchStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student Not Found with ID "+id));
        return modelMapper.map(student, StudentResponseDTO.class);
    }

    @Override
    public void deleteStudentById(Long id) {

        Student student = studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student Not Found with ID "+id));
        studentRepository.deleteById(id);
    }

    @Override
    public StudentResponseDTO updateStudent(Long id, StudentDTO studentDTO) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student Not Found with ID "+id));

        existingStudent.setName(studentDTO.getName());
        existingStudent.setDept_name(studentDTO.getDept_name());
        existingStudent.setEmail(studentDTO.getEmail());
        existingStudent.setAge(studentDTO.getAge());

        Student updatedStudent = studentRepository.save(existingStudent);
        return modelMapper.map(updatedStudent, StudentResponseDTO.class);
    }

    @Override
    public StudentResponseDTO fetchStudentByName(String name) {
        Student student = studentRepository.findByNameIgnoreCase(name).orElseThrow(()->new StudentNotFoundException("No Student named "+name));
        return modelMapper.map(student, StudentResponseDTO.class);
    }
}
