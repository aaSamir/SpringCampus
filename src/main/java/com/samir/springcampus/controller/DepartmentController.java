package com.samir.springcampus.controller;

import com.samir.springcampus.dto.DepartmentDTO;
import com.samir.springcampus.dto.DepartmentResponseDTO;
import com.samir.springcampus.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentResponseDTO> saveDepartment(@Valid @RequestBody DepartmentDTO departmentDTO){
        DepartmentResponseDTO departmentResponseDTO = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(departmentResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<DepartmentResponseDTO>> findAllDepartment(
            @RequestParam(defaultValue = "0")int page_No,
            @RequestParam(defaultValue = "10")int page_size,
            @RequestParam(defaultValue = "name")String sort_by,
            @RequestParam(defaultValue = "asc")String sort_dir
    ){
        Page<DepartmentResponseDTO> departmentResponseDTOS = departmentService.findAllDepartment(page_No, page_size, sort_by, sort_dir);
        return ResponseEntity.ok(departmentResponseDTOS);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentResponseDTO> findDepartmentById(@PathVariable("id") Long id){
        DepartmentResponseDTO departmentResponseDTO = departmentService.findDepartmentById(id);
        return ResponseEntity.ok(departmentResponseDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentResponseDTO> updateDepartment(@PathVariable("id") Long id,@Valid @RequestBody DepartmentDTO departmentDTO){
        DepartmentResponseDTO departmentResponseDTO = departmentService.updateDepartment(id, departmentDTO);
        return ResponseEntity.ok(departmentResponseDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Department deleted successfully");
    }
}
