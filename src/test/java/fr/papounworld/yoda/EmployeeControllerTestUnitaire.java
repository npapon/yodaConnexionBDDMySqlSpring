package fr.papounworld.yoda;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import fr.papounworld.yoda.controller.EmployeeController;
import fr.papounworld.yoda.service.EmployeeService;

@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTestUnitaire {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void testGetEmployees() throws Exception {
    	/*  get est la méthode statique de    MockMvcRequestBuilders 
    	 *  mockMvc.perform( MockMvcRequestBuilders.get("/employees"))*/
        mockMvc.perform(get("/employees"))
            .andExpect(status().isOk());
    }
    
    

    
   
}