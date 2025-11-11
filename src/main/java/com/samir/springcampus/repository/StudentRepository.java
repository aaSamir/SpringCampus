package com.samir.springcampus.repository;

import com.samir.springcampus.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public Optional<Student> findByNameIgnoreCase(@Param("name") String name);
}
