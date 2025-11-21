package com.samir.springcampus.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO used to create or update teacher information")
public class TeacherDTO {

    @Schema(
            description = "Full name of the teacher",
            example = "Asiq Anwar Samir"
    )
    @NotBlank(message = "Name can not be blank")
    private String name;

    @Schema(
            description = "Department Name where teacher works",
            example = "Software Engineering"
    )
    @NotBlank(message = "Department name can not be blank")
    private String dept_name;

    @Schema(
            description = "Valid email of the teacher",
            example = "anwarsamir2017@gmail.com"
    )
    @Email(message = "Please enter a valid email")
    @NotBlank
    private String email;

    @Schema(
            description = "Designation of the teacher",
            example = "Assistant Professor"
    )
    @NotBlank(message = "Designation can not be blank")
    private String designation;
}
