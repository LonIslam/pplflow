package com.pplflow.beemployees.model.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {
    private String name;
    private String contractInformation;
    private int age;
}
