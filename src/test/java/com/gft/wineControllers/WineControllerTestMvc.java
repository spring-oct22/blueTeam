package com.gft.wineControllers;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class WineControllerTestMvc {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@Order (1)
	 public void allWinesTestMvc() throws Exception {
		mockMvc.perform(get("/wines")
			.contentType("application/json"))
			.andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	public void getWineByIdTestMvc() throws Exception {
		mockMvc.perform(get("/api/wine/{id}", 270)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(270)))
				.andExpect(jsonPath("$.name", is("Amancio")));		
	}
	
	@Test
	@Order(3)
	public void postWineTestMvc () throws Exception {
		mockMvc.perform(post("/api/wine" )
				.contentType("application/json")
				.content("{\"id\": 8000, \"name\": \"Mi vino de prueba\", \"year\": \"2007\",\"rating\": 4.6, \"num_reviews\": 70, \"price\": 399.6, \"body\": \"4\", \"acidity\": \"3\", \"winery\": {\"id\": 13, \"name\": \"Sierra Cantabria\"}, \"type\": {\"id\": 8, \"name\": \"Rioja Red\" }, \"region\": {\"id\": 8,\"name\": \"Rioja\", \"country\": \"Espana\"}}")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());		
	}
	
	@Test
	@Order(4)
	public void putWineTestMvc() throws Exception{
		mockMvc.perform(put("/api/wine/{id}")
				.contentType("application/json")
				.content("{\"id\": 8000, \"name\": \"Mi vino de prueba cambiado\", \"year\": \"2007\",\"rating\": 4.6, \"num_reviews\": 70, \"price\": 399.6, \"body\": \"4\", \"acidity\": \"3\", \"winery\": {\"id\": 13, \"name\": \"Sierra Cantabria\"}, \"type\": {\"id\": 8, \"name\": \"Rioja Red\" }, \"region\": {\"id\": 8,\"name\": \"Rioja\", \"country\": \"Espana\"}}"))
				.andExpect(status().isOk());
	}
	
	
	@Test
	@Order(5)
	public void deleteWineTestMvc () throws Exception {
		mockMvc.perform(delete("/api/wine/{id}"))
				.andExpect(status().isOk());
		
	}
	
	

}
