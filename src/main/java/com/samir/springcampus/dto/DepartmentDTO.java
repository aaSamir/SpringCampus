package com.samir.springcampus.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    @NotBlank(message = "Department name can not be blank")
    private String name;

    @Min(value = 0, message = "Total students cannot be negative")
    private int total_student;

    @Min(value = 0, message = "Total Teacher cannot be negative")
    private int total_teacher;

}
