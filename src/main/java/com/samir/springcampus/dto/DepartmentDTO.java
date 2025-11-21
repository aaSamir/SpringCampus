package com.samir.springcampus.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO used to create or update department information")
public class DepartmentDTO {

    @Schema(
            description = "Full name of the department",
            example = "Software Engineering"
    )
    @NotBlank(message = "Department name can not be blank")
    private String name;

    @Schema(
            description = "Total students enrolled in the department",
            example = "100"
    )
    @Min(value = 0, message = "Total students cannot be negative")
    private int total_student;

    @Schema(
            description = "Total teacher appointed in the department",
            example = "10"
    )
    @Min(value = 0, message = "Total Teacher cannot be negative")
    private int total_teacher;

}
