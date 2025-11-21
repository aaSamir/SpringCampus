package com.samir.springcampus.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO response for department information")
public class DepartmentResponseDTO {

    @Schema(
            description = "Unique id of the department",
            example = "101"
    )
    private Long id;

    @Schema(
            description = "Full name of the department",
            example = "Software Engineering"
    )
    private String name;

    @Schema(
            description = "Total students enrolled in the department",
            example = "100"
    )
    private int total_student;

    @Schema(
            description = "Total teacher appointed in the department",
            example = "10"
    )
    private int total_teacher;

}
