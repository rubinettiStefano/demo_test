package com.generation.demo_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
(
  webEnvironment = SpringBootTest.WebEnvironment.MOCK,
  classes = DemoTestApplication.class
)
@AutoConfigureMockMvc
class DemoTestApplicationTests 
{
	//un MockMvc è un oggetto usato nelle classi di test
	//per simulare REQUEST verso il controller
	@Autowired
	MockMvc miniPostman;


	@Test
	void testCalcoloBiglietto() throws Exception 
	{
		//Voglio testare i casi
		//2 anni 
		//12 anni
		//22 anni
		//72 anni
		//122 anni
		//-2 anni

			//2 anni
		miniPostman.
		perform   //FAI LA REQUEST
		(
			MockMvcRequestBuilders.get("/calcolobiglietto/2") //CHE TI IMPOSTO QUI
		)
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Paghi 0"));

		miniPostman.
		perform   //FAI LA REQUEST
		(
			MockMvcRequestBuilders.get("/calcolobiglietto/12") //CHE TI IMPOSTO QUI
		)
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Paghi 5"));

		miniPostman.
		perform   //FAI LA REQUEST
		(
			MockMvcRequestBuilders.get("/calcolobiglietto/22") //CHE TI IMPOSTO QUI
		)
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Paghi 10"));

		miniPostman.
		perform   //FAI LA REQUEST
		(
			MockMvcRequestBuilders.get("/calcolobiglietto/72") //CHE TI IMPOSTO QUI
		)
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Paghi 3"));

		
		miniPostman.
		perform   //FAI LA REQUEST
		(
			MockMvcRequestBuilders.get("/calcolobiglietto/122") //CHE TI IMPOSTO QUI
		)
		.andExpect(MockMvcResultMatchers.status().isNotAcceptable())
		.andExpect(MockMvcResultMatchers.content().string("We Matusa, non ci siamo"));

		miniPostman.
		perform   //FAI LA REQUEST
		(
			MockMvcRequestBuilders.get("/calcolobiglietto/-2") //CHE TI IMPOSTO QUI
		)
		.andExpect(MockMvcResultMatchers.status().isBadRequest())
		.andExpect(MockMvcResultMatchers.content().string("età non valida"));







		//posso mandare anche un BODY
		miniPostman.
		perform   //FAI LA REQUEST
		(
			MockMvcRequestBuilders
			.post("/calcolobiglietto/-2")
			.contentType("application/json")
			.content("{'finto':'json'}") //CHE TI IMPOSTO QUI
		)
		.andExpect(MockMvcResultMatchers.status().isBadRequest())
		.andExpect(MockMvcResultMatchers.content().string("età non valida"));
	}

}
