package com.springboot.employeeservice.controller;

import com.springboot.employeeservice.collection.Employee;
import com.springboot.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@Tag(name = "Employee Controllers")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    @Operation(summary = "Create Employee", description = "Record a new employee by providing the necessary details")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PutMapping
    @Operation(summary = "Update Employee", description = "Update an existing employee with new details")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @GetMapping
    @Operation(summary = "Get All Employees", description = "Retrieve a list of all employees")
    public ResponseEntity<?> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Employee by ID", description = "Retrieve employee details by ID")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        return employeeService.findById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Employee", description = "Delete an employee by ID")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/department/{departmentId}")
    @Operation(summary = "Find Employees by Department", description = "Retrieve employees belonging to a specific department")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId){
        return employeeService.findByDepartment(departmentId);
    }

    @DeleteMapping("/department/{departmentId}")
    @Operation(summary = "Delete Employees by Department", description = "Delete all employees belonging to a specific department")
    public void findByDepartmentAndDelete(@PathVariable("departmentId") Long departmentId){
        employeeService.findByDepartmentAndDelete(departmentId);
    }
}
