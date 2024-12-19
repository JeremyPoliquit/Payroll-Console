package com.project.payroll.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.project.payroll.Entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    // Find By Last Name
    Employee findByLastName(String lastName);

    // Find By First Name
    Employee findByFirstName(String firstName);

    // Find By Id
    Employee findById(long id);

}
