package com.pplflow.beemployees.model.entities;

import com.pplflow.beemployees.model.entities.enums.EmployeeStatus;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "employee")
public class Employee {
    @Id
    private String id;
    private String name;
    private String contractInformation;
    private int age;
    private EmployeeStatus employeeStatus;

    @CreatedDate
    private LocalDateTime creationTimestamp;
    @LastModifiedDate
    private LocalDateTime lastModified;

}
