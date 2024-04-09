package com.springboot.employeeservice.repository;

import com.springboot.employeeservice.collection.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long> {

    List<Employee> findAllByDepartmentId(Long departmentId);

    void deleteAllByDepartmentId(Long departmentId);
}
