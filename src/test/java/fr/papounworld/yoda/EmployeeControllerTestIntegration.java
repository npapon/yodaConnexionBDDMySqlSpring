package fr.papounworld.yoda;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

//on charge le contexte spring à chaque test
@SpringBootTest
//permet d'instancier des MockMvc
@AutoConfigureMockMvc
public class EmployeeControllerTestIntegration {
	
	
	@Autowired
	private MockMvc mockMvc;
	
	//$[0] car c'est un tableau
	@Test
	public void GivenApiGetEmployeesWhenGetEmployeesThenReturnPrenomLaurent()
	{
	
	
		try {
			mockMvc.perform(get("/employees"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].firstname", is("Laurent")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	//pas $[0] car c'est pas un tableau
	@Test
	public void GivenApiGetEmployeesWhenGetEmployeeLeslieThenReturnPrenomLeslie()
	{
	
	
		try {
			mockMvc.perform(get("/employeeleslie"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("firstname", is("Leslie")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
