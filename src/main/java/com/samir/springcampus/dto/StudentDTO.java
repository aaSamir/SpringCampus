package com.samir.springcampus.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO used to create or update student information")
public class StudentDTO {

    @Schema(
            description = "Full name of the student",
            example = "Asiq Anwar Samir"
    )
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Schema(
            description = "Age of the student",
            example = "18"
    )
    @Min(value = 18, message = "Age must be 18 at least")
    private int age;

    @Schema(
            description = "Department Name where student is enrolled",
            example = "Software Engineering"
    )
    @NotBlank(message = "Department Name cannot be blank")
    private String dept_name;

    @Schema(
            description = "Valid email of the student",
            example = "anwarsamir2017@gmail.com"
    )
    @Email(message = "Please enter a valid email")
    private String email;
}
