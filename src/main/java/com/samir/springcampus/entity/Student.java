package com.samir.springcampus.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private Long id;

    @Column(name="s_name")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Column(name="s_age")
    @Min(value = 18, message = "Age must be 18 at least")
    private int age;

    @Column(name="s_dept_name")
    @NotBlank(message = "Department Name cannot be blank")
    private String dept_name;

    @Column(name="s_email")
    @Email(message = "Please enter a valid email")
    private String email;
}
