package com.springboot.departmentservice.controller;

import com.springboot.departmentservice.dto.departmentDTO;
import com.springboot.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/department")
@Tag(name = "Department Controllers")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    @Operation(summary = "Create Department", description = "Record a new department by providing the necessary details")
    public ResponseEntity<String> addDepartment(@RequestBody departmentDTO department){
        return departmentService.addDepartment(department);
    }

    @PutMapping
    @Operation(summary = "Update Department", description = "Update an existing department with new details")
    public ResponseEntity<String> updateDepartment(@RequestBody departmentDTO department){
        return departmentService.updateDepartment(department);
    }

    @GetMapping
    @Operation(summary = "Get All Departments", description = "Retrieve a list of all departments")
    public ResponseEntity<?> findAll(){
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Department by ID", description = "Retrieve department details by ID")
    public ResponseEntity<?>  findById(@PathVariable("id") Long id){
        return departmentService.findById(id);
    }

    @GetMapping("/with-employees/{id}")
    @Operation(summary = "Get Departments with Employees", description = "Retrieve all departments with their employees by department ID")
    public ResponseEntity<?> findAllWthEmployees(@PathVariable("id") Long id){
        return departmentService.findAllWthEmployees(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Department", description = "Delete a department by ID")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id){
        return departmentService.deleteDepartment(id);
    }
}
