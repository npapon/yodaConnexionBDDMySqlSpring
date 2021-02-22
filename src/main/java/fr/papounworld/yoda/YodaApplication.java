package fr.papounworld.yoda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.papounworld.yoda.model.Employee;
import fr.papounworld.yoda.repository.EmployeeRepository;
import fr.papounworld.yoda.service.EmployeeService;

import java.util.ArrayList;



@SpringBootApplication
public class YodaApplication implements CommandLineRunner{

	@Autowired
	private EmployeeService employeeService;
	
	public static void main(String[] args) {
		SpringApplication.run(YodaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Employee employee = new Employee();
		
		employee.setFirstname("Nicolas");
		employee.setLastname("Papon");
		employee.setMail("npapon@live.fr");
		employee.setPassword("Patapoun123");
		employeeService.saveEmployee(employee);
	
		
		
	}
	

	
}

