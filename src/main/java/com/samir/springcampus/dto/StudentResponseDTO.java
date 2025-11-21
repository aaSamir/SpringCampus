package com.samir.springcampus.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO response for student information")
public class StudentResponseDTO {

    @Schema(
            description = "Unique id of the student",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Full name of the student",
            example = "Asiq Anwar Samir"
    )
    private String name;

    @Schema(
            description = "Age of the student",
            example = "18"
    )
    private int age;

    @Schema(
            description = "Department Name where student is enrolled",
            example = "Software Engineering"
    )
    private String dept_name;

    @Schema(
            description = "Valid email of the student",
            example = "anwarsamir2017@gmail.com"
    )
    private String email;
}
