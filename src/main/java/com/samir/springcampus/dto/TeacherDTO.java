package com.samir.springcampus.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {

    @NotBlank(message = "Name can not be blank")
    private String name;

    @NotBlank(message = "Department name can not be blank")
    private String dept_name;

    @Email(message = "Please enter a valid email")
    @NotBlank
    private String email;

    @NotBlank(message = "Designation can not be blank")
    private String designation;
}
