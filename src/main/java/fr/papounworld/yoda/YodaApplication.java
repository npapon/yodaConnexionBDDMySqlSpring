package fr.papounworld.yoda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.papounworld.yoda.model.Employee;
import fr.papounworld.yoda.service.EmployeeService;



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
	

Employee employee2 = new Employee();
		
		employee2.setFirstname("lAURE");
		employee2.setLastname("chenu");
		employee2.setMail("npapon@live.fr");
		employee2.setPassword("Patapoun123");
		employeeService.saveEmployee(employee);
		
		List<Employee> listEmployee = new ArrayList<Employee>();
		listEmployee.add(employee);
		listEmployee.add(employee2);
		
		Iterator<Employee> iteratorNormal = listEmployee.iterator();

		while(iteratorNormal.hasNext()) {
			System.out.println(iteratorNormal.next().getFirstname());
		}

		
		//mais ca a l'air de marche ainsi direct 
		Iterator iteratorNormal2 = new Iterable<Employee>() {
			List<Employee> list = new ArrayList<>();
			

			@Override
			public Iterator<Employee> iterator() {
				
				list.add(employee);
				list.add(employee2);
				// TODO Auto-generated method stub
				return list.iterator();
			}}.iterator();

		
			while(iteratorNormal2.hasNext()) {
				System.out.println("begin");
				System.out.println(((Employee) iteratorNormal2.next()).getFirstname());
				System.out.println("end");
			}

			
			
		Iterable<Employee> employees  = employeeService.getEmployees();
	
		//et la au lieu d'avoir une liste on a direct employees (donc je pense 
		
		Iterator<Employee> iterator = employees.iterator() ;
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getFirstname());
		}
		


	
}

}