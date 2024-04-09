package com.springboot.employeeservice.service;

import com.springboot.employeeservice.client.DepartmentClient;
import com.springboot.employeeservice.collection.Employee;
import com.springboot.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    private final DepartmentClient departmentClient;

    @Override
    public ResponseEntity<String> addEmployee(Employee employee) {
        Optional<Employee> existingEmployee  = employeeRepository.findById(employee.getId());

        try {
            departmentClient.findById(employee.getDepartmentId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Department not exist yet. Department Id:" + employee.getDepartmentId());
        }

        if(existingEmployee.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("A employee with the given id already exists");
        } else{
            if(employee.getDepartmentId() == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee department id is required");
            } else if (employee.getName() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee name is required");
            } else if (employee.getAge() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee age is required");
            } else if (employee.getPosition() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee position is required");
            } else{
                employeeRepository.save(employee);
                return ResponseEntity.status(HttpStatus.CREATED).body("Employee created successfully");
            }
        }
    }

    @Override
    public ResponseEntity<String> updateEmployee(Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(employee.getId());

        try {
            departmentClient.findById(employee.getDepartmentId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Department not exist yet. Department Id:" + employee.getDepartmentId());
        }

        if (existingEmployee.isPresent()) {
            if(employee.getDepartmentId() == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee department id is required");
            } else if (employee.getName() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee name is required");
            } else if (employee.getAge() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee age is required");
            } else if (employee.getPosition() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee position is required");
            }else {
                employeeRepository.save(employee);
                return ResponseEntity.ok("Employee updated successfully");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }

    @Override
    public ResponseEntity<?> findAll() {
        List<Employee> employees = employeeRepository.findAll();

        if(!employees.isEmpty()){
            return ResponseEntity.ok(employees);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There are no employees exist yet");
        }
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);

        if(existingEmployee.isPresent()){
            return ResponseEntity.ok(existingEmployee.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }

    @Override
    public ResponseEntity<String> deleteEmployee(Long id) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);

        if(existingEmployee.isPresent()){
            employeeRepository.deleteById(id);
            return ResponseEntity.ok("Employee successfully deleted. Employee Id: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }

    @Override
    public List<Employee> findByDepartment(Long departmentId) {
        return employeeRepository.findAllByDepartmentId(departmentId);
    }

    @Override
    public void findByDepartmentAndDelete(Long departmentId) {
        employeeRepository.deleteAllByDepartmentId(departmentId);
    }
}
