package com.pplflow.beemployees;

import com.pplflow.beemployees.controller.EmployeeController;
import com.pplflow.beemployees.model.entities.dto.EmployeeDto;
import com.pplflow.beemployees.model.entities.dto.EmployeeResponse;
import com.pplflow.beemployees.model.entities.enums.EmployeeStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DirtiesContext
@SpringBootTest
class BeEmployeesApplicationTests {

    @Autowired
    EmployeeController employeeController;

    @Test
    void contextLoads() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setAge(26);
        employeeDto.setName("Islam");
        employeeDto.setContractInformation("2 years contract");

        ResponseEntity responseEntity = employeeController.addEmployee(employeeDto);
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        EmployeeResponse createdEmployee = (EmployeeResponse) responseEntity.getBody();
        Assert.assertEquals(employeeDto.getAge(), createdEmployee.getAge());
        Assert.assertEquals(EmployeeStatus.ADDED, createdEmployee.getEmployeeStatus());
        Assert.assertEquals(employeeDto.getName(), createdEmployee.getName());
        Assert.assertEquals(employeeDto.getContractInformation(), createdEmployee.getContractInformation());
        Assert.assertNotNull(createdEmployee.getId());
    }
}
