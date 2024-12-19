package com.project.payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.payroll.Entity.Employee;
import com.project.payroll.Repository.EmployeeRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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
			Scanner sc = new Scanner(System.in);

			try {
				do {

					// Fetch all Data
					repository.findAll().forEach(employeeData -> {
						System.out.println(employeeData);
					});

					System.out.println("Command: Create = C / Update = U / Get = G ");
					System.out.print("Type: ");
					String cmd = sc.nextLine().toUpperCase();

					switch (cmd) {
						case "C":
							System.out.print("Employee First Name: ");
							String fname = sc.nextLine();

							System.out.print("Employee Last Name: ");
							String lname = sc.nextLine();

							System.out.print("Employee Gender: ");
							String sex = sc.nextLine();

							// Process
							employee.setFirstName(fname);
							employee.setLastName(lname);
							employee.setSex(sex);

							// Saving the Data
							repository.save(employee);
							break;

						case "U":
							System.out.println("Update Data: Firstname = F / Lastname = L / Sex = S");
							System.out.print("Select Command: ");
							String updateCMD = sc.nextLine().toUpperCase();

							if (updateCMD.equals("F")) {
								System.out.print("Current Firstname: ");
								String fnameCurrent = sc.nextLine();
								System.out.print("New Firstname: ");
								String fnameUpdate = sc.nextLine();

								// Process
								Employee firstName = repository.findByFirstName(fnameCurrent);
								if (firstName != null) {
									firstName.getFirstName();
									firstName.setFirstName(fnameUpdate);
									repository.save(firstName);
									System.out.println("Update Successfully");
								}
							} else if (updateCMD.equals("L")) {
								System.out.print("Current Lastname: ");
								String lnameCurrent = sc.nextLine();
								System.out.print("New Lastname: ");
								String lnameUpdate = sc.nextLine();

								// Process
								Employee lastName = repository.findByLastName(lnameCurrent);
								if (lastName != null) {
									lastName.getLastName();
									lastName.setLastName(lnameUpdate);
									repository.save(lastName);
									System.out.println("Update Successfully");
								}
							}
							break;

						default:
							break;
					}

				} while (true);
			} catch (Exception err) {
				System.out.println(err);
			}

			// Employee entity = repository.findByFirstName("John");
			// if (entity != null) {
			// entity.getFirstName();
			// entity.setFirstName("Rodrigo");
			// repository.save(entity);
			// }

		};
	}

}
