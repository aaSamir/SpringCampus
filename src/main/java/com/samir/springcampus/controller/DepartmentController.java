package com.samir.springcampus.controller;

import com.samir.springcampus.dto.DepartmentDTO;
import com.samir.springcampus.dto.DepartmentResponseDTO;
import com.samir.springcampus.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Tag(name = "Department Controller", description = "Endpoints for managing department operations")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Operation(summary = "Save new Department", description = "Creates a new department using DepartmentDTO")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Department successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid request body")
    })
    @PostMapping
    public ResponseEntity<DepartmentResponseDTO> saveDepartment(@Valid @RequestBody DepartmentDTO departmentDTO){
        DepartmentResponseDTO departmentResponseDTO = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(departmentResponseDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Get all departments", description = "Pagination+Sorting supported")
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

    @Operation(summary = "Get department by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Department found"),
            @ApiResponse(responseCode = "404", description = "Department not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponseDTO> findDepartmentById(@PathVariable("id") Long id){
        DepartmentResponseDTO departmentResponseDTO = departmentService.findDepartmentById(id);
        return ResponseEntity.ok(departmentResponseDTO);
    }

    @Operation(summary = "Update department by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Department updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body"),
            @ApiResponse(responseCode = "404", description = "Department not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponseDTO> updateDepartment(@PathVariable("id") Long id,@Valid @RequestBody DepartmentDTO departmentDTO){
        DepartmentResponseDTO departmentResponseDTO = departmentService.updateDepartment(id, departmentDTO);
        return ResponseEntity.ok(departmentResponseDTO);
    }

    @Operation(summary = "Delete department by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Department deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Department not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Department deleted successfully");
    }
}
