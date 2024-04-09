package com.springboot.departmentservice.service;

import com.springboot.departmentservice.dto.departmentDTO;
import org.springframework.http.ResponseEntity;

public interface DepartmentService {
    ResponseEntity<String> addDepartment(departmentDTO department);

    ResponseEntity<String> updateDepartment(departmentDTO department);

    ResponseEntity<?> findAll();

    ResponseEntity<?>  findById(Long id);

    ResponseEntity<?> findAllWthEmployees(Long id);

    ResponseEntity<String> deleteDepartment(Long id);
}
