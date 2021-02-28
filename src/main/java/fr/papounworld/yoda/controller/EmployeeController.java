package fr.papounworld.yoda.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	/**
	 * Read - Get one employee 
	 * @param id The id of the employee
	 * @return An Employee object full filled
	 */
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable("id") final Long id) {
		Optional<Employee> employee = employeeService.getEmployee(id);
		if(employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}
	}
	
	/**
	 * Create - Add a new employee
	 * @param employee An object employee
	 * @return The employee object saved
	 */
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	
	@PutMapping("/employee/{id}")
	//dans PathVariable on met l'id de l'endpoint
	//et RequestBody on met en paramètre un body d'employée (json)
	public Employee updateEmployee(@PathVariable("id") final Long id, @RequestBody Employee employeeMisAJour) {
		//On récupérer l'employé de l'id et on l'instancie dans un Optional (un Employee)
		Optional<Employee> OptionalEmployeeEndpoint = employeeService.getEmployee(id);
		//Si l'optional est présent donc que dans le endPoint à ramener un employeé
		//on instancie cette fois avec l'employé qu'il contient un vrai objet employé
		if(OptionalEmployeeEndpoint.isPresent()) {
			Employee EndPointEmployee = OptionalEmployeeEndpoint.get();
			
			//on récupére cette fois ci via le body mis en paramétre le prénom si renseigné
			//et on met à jour le employee du endpoint avec
			String firstName = employeeMisAJour.getFirstname();
			if(firstName != null) {
				EndPointEmployee.setFirstname(firstName);
			}
			
			//idem pour le reste 
			String lastName = employeeMisAJour.getLastname();
			if(lastName != null) {
				EndPointEmployee.setLastname(lastName);;
			}
			String mail = employeeMisAJour.getMail();
			if(mail != null) {
				EndPointEmployee.setMail(mail);
			}
			String password = employeeMisAJour.getPassword();
			if(password != null) {
				EndPointEmployee.setPassword(password);;
			}
			//on enregistre l'employee du endpoint mis à jour
			employeeService.saveEmployee(EndPointEmployee);
			//et on retourne cette employée
			return EndPointEmployee;
		} else {
			//par contre si l'id du endpoint avait rien remonté on retourne null
			return null;
		}
	}
	
	
	
	/**
	 * Delete - Delete an employee
	 * @param id - The id of the employee to delete
	 */
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable("id") final Long id) {
		employeeService.deleteEmployee(id);
	}
	

	/*
	@PostMapping("/createemployee")
	public Employee creerEmployee()
	{Employee employee = new Employee();
	employee.setFirstname("Franck");
	employee.setLastname("Potin");
	employee.setMail("franck.potin@canal-plus");
	employee.setPassword("Patapoun123");
		
		return employeeService.saveEmployee(employee);}
	
	@GetMapping("/employeeleslie")
	public Optional<Employee> getEmployeeLeslie(){
		return employeeService.getEmployee((long) 2);
	}
	*/
	

}
