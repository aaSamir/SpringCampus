package com.samir.springcampus.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @Column(name="t_Id")
    private Long id;

    @NotBlank(message = "Name can not be blank")
    private String t_name;

    @NotBlank(message = "Department name can not be blank")
    private String t_deptName;

    @Email(message = "Please enter a valid email")
    @NotBlank
    private String t_email;

    @NotBlank(message = "Designation can not be blank")
    private String designation;
}
