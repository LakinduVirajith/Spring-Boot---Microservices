package com.springboot.departmentservice.collection;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Long id;
    private Long departmentId;
    private String name;
    private Integer age;
    private String position;
}
