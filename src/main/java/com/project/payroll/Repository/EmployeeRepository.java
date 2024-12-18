package com.project.payroll.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.project.payroll.Entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    // Retrieve Data
    List<Employee> findByLastName(String lastName);
    Employee findById(long id);
}
