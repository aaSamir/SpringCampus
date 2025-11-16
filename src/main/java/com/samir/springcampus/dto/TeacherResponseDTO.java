package com.samir.springcampus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherResponseDTO {

    private Long id;
    private String name;
    private String dept_name;
    private String email;
    private String designation;
}
