package com.samir.springcampus.service;

import com.samir.springcampus.entity.Student;
import com.samir.springcampus.entity.Teacher;
import com.samir.springcampus.exception.TeacherNotFoundException;
import com.samir.springcampus.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Teacher> fetchAllTeacher() {
        return teacherRepository.findAll();
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
