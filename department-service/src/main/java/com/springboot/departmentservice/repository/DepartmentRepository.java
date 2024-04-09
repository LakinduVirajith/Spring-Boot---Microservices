package com.springboot.departmentservice.repository;

import com.springboot.departmentservice.collection.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, Long> {

}
