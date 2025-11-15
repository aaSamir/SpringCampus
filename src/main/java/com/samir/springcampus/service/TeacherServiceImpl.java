package com.samir.springcampus.service;

import com.samir.springcampus.dto.TeacherDTO;
import com.samir.springcampus.dto.TeacherResponseDTO;
import com.samir.springcampus.entity.Teacher;
import com.samir.springcampus.exception.TeacherNotFoundException;
import com.samir.springcampus.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TeacherResponseDTO saveTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = modelMapper.map(teacherDTO, Teacher.class);
        Teacher saved_teacher = teacherRepository.save(teacher);
        return modelMapper.map(saved_teacher, TeacherResponseDTO.class);
    }

    @Override
    public Page<TeacherResponseDTO> fetchAllTeacher(int page_no, int page_size, String sort_by, String sort_dir) {
        Sort sort = sort_by.equalsIgnoreCase("asc")?Sort.by(sort_by).ascending():Sort.by(sort_by).descending();
        Pageable pageable = PageRequest.of(page_no, page_size, sort);
        Page<Teacher>teacherPage = teacherRepository.findAll(pageable);
        return teacherPage.map(teacher -> modelMapper.map(teacher, TeacherResponseDTO.class));
    }

    @Override
    public TeacherResponseDTO fetchTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(()->new TeacherNotFoundException("Teacher Not Found with ID "+id));
        return modelMapper.map(teacher, TeacherResponseDTO.class);
    }

    @Override
    public void deleteTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(()->new TeacherNotFoundException("Teacher Not Found with ID "+id));

        teacherRepository.deleteById(id);
    }

    @Override
    public TeacherResponseDTO updateTeacher(Long id, TeacherDTO teacherDTO) {
        Teacher existing_teacher = teacherRepository.findById(id).orElseThrow(()-> new TeacherNotFoundException("Teacher Not Found with ID "+id));

        existing_teacher.setName(teacherDTO.getName());
        existing_teacher.setEmail(teacherDTO.getEmail());
        existing_teacher.setDept_name(teacherDTO.getDept_name());
        existing_teacher.setDesignation(teacherDTO.getDesignation());

        Teacher updated_teacher = teacherRepository.save(existing_teacher);
        return modelMapper.map(updated_teacher, TeacherResponseDTO.class);
    }


}
