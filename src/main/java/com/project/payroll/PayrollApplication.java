package com.project.payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.payroll.Entity.Employee;
import com.project.payroll.Repository.EmployeeRepository;

import java.util.Scanner;


@SpringBootApplication
public class PayrollApplication {

	private static final Logger log = LoggerFactory.getLogger(PayrollApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PayrollApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EmployeeRepository repository) {
		return (args) -> {
			Employee employee = new Employee();

			// Set the data
			// employee.setFirstName("");
			// employee.setLastName("");
			// employee.setSex('');
	
			//  Save/Store or Insert into Database
			repository.save(employee);
	
			// Fetch all Data
			log.info("Employee found with findAll();");
			log.info("-------------------------------");
			repository.findAll().forEach(employeeData -> {
				log.info(employeeData.toString());
				System.out.println(employeeData);
			});


			// Find by Last Name
			log.info("Employee find by Lastname ");
			repository.findByLastName("Palmer").forEach(Palmer -> {
				log.info(Palmer.toString());
			});
		};
	}

}
