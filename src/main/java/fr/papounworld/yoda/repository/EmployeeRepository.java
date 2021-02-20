package fr.papounworld.yoda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.papounworld.yoda.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}