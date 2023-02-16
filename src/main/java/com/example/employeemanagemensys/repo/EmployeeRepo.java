package com.example.employeemanagemensys.repo;

import com.example.employeemanagemensys.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//primary key of the entity is Integer. therefore, we use Integer in the generic type.
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
