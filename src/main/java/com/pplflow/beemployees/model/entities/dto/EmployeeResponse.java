package com.pplflow.beemployees.model.entities.dto;

import com.pplflow.beemployees.model.entities.enums.EmployeeStatus;
import lombok.Data;

@Data
public class EmployeeResponse {
    private String id;
    private String name;
    private String contractInformation;
    private int age;
    private EmployeeStatus employeeStatus;
}
