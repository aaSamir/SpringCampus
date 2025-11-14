package com.samir.springcampus.service;

import com.samir.springcampus.entity.Student;
import com.samir.springcampus.entity.Teacher;
import com.samir.springcampus.exception.TeacherNotFoundException;
import com.samir.springcampus.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Page<Teacher> fetchAllTeacher(int page_no, int page_size, String sort_by, String sort_dir) {
        Sort sort = sort_by.equalsIgnoreCase("asc")?Sort.by(sort_by).ascending():Sort.by(sort_by).descending();
        Pageable pageable = PageRequest.of(page_no, page_size, sort);
        return teacherRepository.findAll(pageable);
    }

    @Override
    public Teacher fetchTeacherById(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if(teacher.isEmpty()){
            throw new TeacherNotFoundException("Teacher Not Found with ID "+id);
        }
        return teacher.get();
    }

    @Override
    public void deleteTeacherById(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if(teacher.isEmpty()){
            throw new TeacherNotFoundException("Teacher Not Found with ID "+id);
        }
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher teacher) {
        Optional<Teacher> existingTeacher = teacherRepository.findById(id);
        if(existingTeacher.isEmpty()){
            throw new TeacherNotFoundException("Teacher Not Found with ID "+id);
        }

        Teacher updatedTeacher = existingTeacher.get();

        updatedTeacher.setT_email(teacher.getT_email());
        updatedTeacher.setT_deptName(teacher.getT_deptName());
        updatedTeacher.setDesignation(teacher.getDesignation());

        return teacherRepository.save(updatedTeacher);
    }


}
