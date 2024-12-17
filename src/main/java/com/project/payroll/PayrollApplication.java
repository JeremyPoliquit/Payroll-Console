package com.project.payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.project.payroll.Entity.Employee;
import com.project.payroll.Entity.Salary;
import com.project.payroll.Repository.EmployeeRepository;

import jakarta.transaction.Transactional;

import java.util.Scanner;

@SpringBootApplication
@Component
public class PayrollApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(PayrollApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		try {

			Employee employee = new Employee();
			Salary salary = new Salary();
			Scanner sc = new Scanner(System.in);

			System.out.println("--- Employee Information ---");
			System.out.print("Employee First Name: ");
			String firstNameString = sc.nextLine();

			System.out.print("Employee Last Name: ");
			String lastNameString = sc.nextLine();

			System.out.print("Employee Gender: ");
			String genderString = sc.nextLine();


			
			System.out.println("--- Employee Salary ---");
			System.out.print("Salary: ");
			double salaryDouble = sc.nextDouble();

			System.out.print("Hours Worked: ");
			int hoursWorkedInteger = sc.nextInt();


			employee.setFirstName(firstNameString);
			employee.setLastName(lastNameString);
			employee.setSex(genderString);
			
			salary.setAmount(salaryDouble);
			salary.setHoursWorked(hoursWorkedInteger);
			
			// Associate Employee with Salary
			employee.setSalary(salary);
			salary.setEmployee(employee);
			
			// Save to database
			employeeRepository.save(employee);
			
			System.out.println("\n --- Employee Detail --- \n");
			
			System.out.println("First Name: " + firstNameString);
			System.out.println("Last Name: " + lastNameString);
			System.out.println("Gender: " + genderString + "\n");

			System.out.println("Salary: " + salaryDouble);
			System.out.println("Hours Worked: " + hoursWorkedInteger);
			System.out.println("Employee and Salary saved successfully! \n");
			System.out.println("--- Employee Detail ---");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
