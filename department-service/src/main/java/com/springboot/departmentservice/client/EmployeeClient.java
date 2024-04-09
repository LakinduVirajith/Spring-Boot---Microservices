package com.springboot.departmentservice.client;

import com.springboot.departmentservice.collection.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {

    @GetExchange("/api/v1/employee/department/{departmentId}")
    List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId);

    @DeleteExchange("/api/v1/employee/department/{departmentId}")
    void findByDepartmentAndDelete(@PathVariable("departmentId") Long departmentId);
}
