package com.gft.wineControllers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class TypeControllerTetMvc {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@Order (1)
	 public void allTypesTestMvc() throws Exception {
		mockMvc.perform(get("/types")
			.contentType("application/json"))
			.andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	public void getTypeByIdTestMvc() throws Exception {
		mockMvc.perform(get("/api/type/{id}", 5)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(5)))
				.andExpect(jsonPath("$.name", is("Red")));		
	}
	
	@Test
	@Order(3)
	public void postTypeTestMvc () throws Exception {
		mockMvc.perform(post("/api/type" )
				.contentType("application/json")
				.content("{\"id\": 25, \"name\": \"Mi tipo de prueba\"}}")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());		
	}
	
	@Test
	@Order(4)
	public void putTypeTestMvc() throws Exception{
		mockMvc.perform(put("/api/type/{id}")
				.contentType("application/json")
				.content("{\"id\": 25, \"name\": \"Mi bodega de prueba2\"}}"))
				.andExpect(status().isOk());
	}
	
	
	@Test
	@Order(5)
	public void deleteTypeTestMvc () throws Exception {
		mockMvc.perform(delete("/api/type/{id}"))
				.andExpect(status().isOk());
		
	}

}
