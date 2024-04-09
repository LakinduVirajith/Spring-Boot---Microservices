package com.springboot.employeeservice.service;

import com.springboot.employeeservice.collection.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    ResponseEntity<String> addEmployee(Employee employee);

    ResponseEntity<String> updateEmployee(Employee employee);

    ResponseEntity<?> findAll();

    ResponseEntity<?> findById(Long id);

    ResponseEntity<String> deleteEmployee(Long id);

    List<Employee> findByDepartment(Long departmentId);

    void findByDepartmentAndDelete(Long departmentId);
}
