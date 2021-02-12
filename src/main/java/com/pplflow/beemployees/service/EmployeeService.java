package com.pplflow.beemployees.service;

import com.pplflow.beemployees.model.entities.Employee;
import com.pplflow.beemployees.model.entities.dto.EmployeeDto;
import com.pplflow.beemployees.model.entities.dto.EmployeeResponse;
import com.pplflow.beemployees.model.entities.enums.EmployeeStatus;
import com.pplflow.beemployees.model.repo.EmployeeRepository;
import com.pplflow.beemployees.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public ResponseEntity<EmployeeResponse> createEmployee(EmployeeDto employeeDto) {
        if (employeeDto.getName() != null && employeeDto.getAge() > 0) {
            Employee employee = Util.getModelMapper().map(employeeDto, Employee.class);
            employee.setEmployeeStatus(EmployeeStatus.ADDED);
            employeeRepository.save(employee);
            EmployeeResponse employeeResponse = Util.getModelMapper().map(employee, EmployeeResponse.class);
            return ResponseEntity.ok(employeeResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }

    public ResponseEntity<EmployeeResponse> updateEmployee(String id, EmployeeStatus employeeStatus) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            employeeOptional.get().setEmployeeStatus(employeeStatus);
            employeeRepository.save(employeeOptional.get());
            EmployeeResponse employeeResponse = Util.getModelMapper().map(employeeOptional.get(), EmployeeResponse.class);
            return ResponseEntity.ok(employeeResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponse> employeesResponseList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        employees.stream().forEach(employee ->
                employeesResponseList.add(modelMapper.map(employee, EmployeeResponse.class)));
        return ResponseEntity.ok(employeesResponseList);
    }

    public ResponseEntity<EmployeeResponse> getEmployee(String id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            EmployeeResponse employeeResponse = Util.getModelMapper().map(employeeOptional.get(), EmployeeResponse.class);
            return ResponseEntity.ok(employeeResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
