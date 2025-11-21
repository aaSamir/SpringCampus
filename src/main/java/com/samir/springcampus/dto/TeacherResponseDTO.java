package com.samir.springcampus.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO Response for teacher information")
public class TeacherResponseDTO {

    @Schema(
            description = "Unique id of the teacher",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Full name of the teacher",
            example = "Asiq Anwar Samir"
    )
    private String name;

    @Schema(
            description = "Department Name where teacher works",
            example = "Software Engineering"
    )
    private String dept_name;

    @Schema(
            description = "Valid email of the teacher",
            example = "anwarsamir2017@gmail.com"
    )
    private String email;

    @Schema(
            description = "Designation of the teacher",
            example = "Assistant Professor"
    )
    private String designation;
}
