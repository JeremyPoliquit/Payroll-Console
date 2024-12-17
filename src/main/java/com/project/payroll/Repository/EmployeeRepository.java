package com.project.payroll.Repository;

import org.springframework.data.repository.CrudRepository;

import com.project.payroll.Entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    
}
