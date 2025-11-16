package com.samir.springcampus.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Department")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Long id;

    @NotBlank(message = "Department name can not be blank")
    @Column(name = "dept_name")
    private String name;

    @Min(value = 0, message = "Total students cannot be negative")
    @Column(name = "total_student")
    private int total_student;

    @Column(name = "total_teacher")
    @Min(value = 0, message = "Total Teacher cannot be negative")
    private int total_teacher;

}
