package fr.papounworld.yoda.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/*
 * CREATE TABLE employees (
	id INT AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(250) NOT NULL,
	last_name VARCHAR(250) NOT NULL,
	mail VARCHAR(250) NOT NULL,
	password VARCHAR(250) NOT NULL
	);
 */

@Data
@Entity
@Table(name ="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
    @Column(name="first_name")
    private String firstname ;
    
    @Column(name="last_name")
    private String lastname ;
    
    private String mail;
    
    private String password;
	
	
	

}
