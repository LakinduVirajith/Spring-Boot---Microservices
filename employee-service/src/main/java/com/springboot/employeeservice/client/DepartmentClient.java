package com.springboot.employeeservice.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface DepartmentClient {

    @GetExchange("/api/v1/department/{id}")
    ResponseEntity<?> findById(@PathVariable("id") Long id);
}
