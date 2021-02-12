package com.pplflow.beemployees.controller;

import com.pplflow.beemployees.model.entities.dto.EmployeeDto;
import com.pplflow.beemployees.model.entities.dto.EmployeeResponse;
import com.pplflow.beemployees.model.entities.enums.EmployeeStatus;
import com.pplflow.beemployees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/employee", produces = APPLICATION_JSON_VALUE)
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/")
    public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.createEmployee(employeeDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable("id") String id,
                                                           @RequestParam EmployeeStatus employeeStatus) throws IOException {
        return employeeService.updateEmployee(id, employeeStatus);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable("id") String id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}