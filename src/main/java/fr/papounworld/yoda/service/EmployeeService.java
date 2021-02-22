package fr.papounworld.yoda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.papounworld.yoda.model.Employee;
import fr.papounworld.yoda.repository.EmployeeRepository;
import lombok.Data;

@Data
@Service
public class EmployeeService {
	
	// on déclare l'attribut qui permet juste de communiquer avec la bdd
	// pas besoin de l'instancier car il a été créé avec l'attribut @Repository (iso Component)
	//et @Autowired remplace le new
	//EmployeeRepository dispose de méthode qui permette de communitquer avec la bdd
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Optional<Employee> getEmployee(final Long id){
		return employeeRepository.findById(id);
	}
	
	public Iterable<Employee> getEmployees(){
		return employeeRepository.findAll();
	}
	
	public void deleteEmployee(final Long id)
	{employeeRepository.deleteById(id);}
	
	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee = employeeRepository.save(employee);
		return employee;
		
	}

}
