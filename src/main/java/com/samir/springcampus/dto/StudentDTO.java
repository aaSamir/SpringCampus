package com.samir.springcampus.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {


    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 18, message = "Age must be 18 at least")
    private int age;

    @NotBlank(message = "Department Name cannot be blank")
    private String dept_name;

    @Email(message = "Please enter a valid email")
    private String email;
}
