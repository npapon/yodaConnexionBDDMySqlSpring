package fr.papounworld.yoda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.papounworld.yoda.model.Employee;
import fr.papounworld.yoda.service.EmployeeService;


@RestController
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public Iterable<Employee> getEmployees(){
		return employeeService.getEmployees();
	}

}
