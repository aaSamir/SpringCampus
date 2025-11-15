package com.samir.springcampus.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="t_id")
    private Long id;

    @Column(name="t_name")
    @NotBlank(message = "Name can not be blank")
    private String name;

    @Column(name="t_dept_name")
    @NotBlank(message = "Department name can not be blank")
    private String dept_name;

    @Column(name="t_email")
    @Email(message = "Please enter a valid email")
    @NotBlank
    private String email;

    @Column(name="designation")
    @NotBlank(message = "Designation can not be blank")
    private String designation;
}
