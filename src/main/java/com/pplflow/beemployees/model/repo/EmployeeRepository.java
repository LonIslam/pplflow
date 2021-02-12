package com.pplflow.beemployees.model.repo;

import com.pplflow.beemployees.model.entities.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
