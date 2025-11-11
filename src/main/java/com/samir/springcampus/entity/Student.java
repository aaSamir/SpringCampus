package com.samir.springcampus.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @Column(name = "s_Id")
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 18, message = "Age must be 18 at least")
    private int age;

    @NotBlank(message = "Department Name cannot be blank")
    private String deptName;

    @Email(message = "Please enter a valid email")
    private String email;
}
