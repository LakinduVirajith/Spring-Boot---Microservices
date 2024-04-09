package com.springboot.departmentservice.service;

import com.springboot.departmentservice.client.EmployeeClient;
import com.springboot.departmentservice.collection.Department;
import com.springboot.departmentservice.collection.Employee;
import com.springboot.departmentservice.dto.departmentDTO;
import com.springboot.departmentservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;

    private final EmployeeClient employeeClient;

    @Override
    public ResponseEntity<String> addDepartment(departmentDTO department) {
        Optional<Department> existingDepartment = departmentRepository.findById(department.getId());

        if(existingDepartment.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("A department with the given id already exists");
        }else{
            if(department.getName() == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Department name is required");
            }else{
                Department departmentObj = Department.builder()
                        .id(department.getId())
                        .name(department.getName()).build();

                departmentRepository.save(departmentObj);
                return ResponseEntity.status(HttpStatus.CREATED).body("Department created successfully");
            }
        }
    }

    @Override
    public ResponseEntity<String> updateDepartment(departmentDTO department) {
        Optional<Department> existingDepartment = departmentRepository.findById(department.getId());

        if (existingDepartment.isPresent()) {
            if(department.getName() == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Department name is required");
            }else {
                Department departmentObj = Department.builder()
                        .id(department.getId())
                        .name(department.getName()).build();

                departmentRepository.save(departmentObj);
                return ResponseEntity.ok("Department updated successfully");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found");
        }
    }

    @Override
    public ResponseEntity<?>  findAll() {
        List<Department> departments = departmentRepository.findAll();

        if(!departments.isEmpty()){
            return ResponseEntity.ok(departments);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There are no departments exist yet");
        }
    }

    @Override
    public ResponseEntity<?>  findById(Long id) {
        Optional<Department> existingDepartment = departmentRepository.findById(id);

        if(existingDepartment.isPresent()){
            return ResponseEntity.ok(existingDepartment.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found");
        }
    }

    @Override
    public ResponseEntity<?> findAllWthEmployees(Long id) {
        Optional<Department> existingDepartment = departmentRepository.findById(id);

        if(existingDepartment.isPresent()){
            Department department = existingDepartment.get();

            List<Employee> employees = employeeClient.findByDepartment(id);
            department.setEmployees(employees);
            return ResponseEntity.ok(department);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found");
        }
    }

    @Override
    @Transactional
    public ResponseEntity<String> deleteDepartment(Long id) {
        Optional<Department> existingDepartment = departmentRepository.findById(id);

        if(existingDepartment.isPresent()){
            departmentRepository.deleteById(id);
            employeeClient.findByDepartmentAndDelete(id);
            return ResponseEntity.ok("Department successfully deleted. Department Id: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found");
        }
    }
}
