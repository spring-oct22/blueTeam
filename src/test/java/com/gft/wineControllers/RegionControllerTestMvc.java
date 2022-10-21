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
class RegionControllerTetMvc {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@Order (1)
	 public void allRegionsTestMvc() throws Exception {
		mockMvc.perform(get("/regions")
			.contentType("application/json"))
			.andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	public void getRegionByIdTestMvc() throws Exception {
		mockMvc.perform(get("/api/region/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.name", is("Toro")));		
	}
	
	@Test
	@Order(3)
	public void postRegionTestMvc () throws Exception {
		mockMvc.perform(post("/api/region" )
				.contentType("application/json")
				.content("{\"id\": 80, \"name\": \"Mi region de prueba, \"country\": \"Espana\"}}")
				.accept(MediaType.APPLICATION_JSON))
		
				.andExpect(status().isOk());		
	}
	
	@Test
	@Order(4)
	public void putRegionTestMvc() throws Exception{
		mockMvc.perform(put("/api/region/{id}")
				.contentType("application/json")
				.content("{\"id\": 80, \"name\": \"Mi region de prueba2, \"country\": \"España\"}}"))
				.andExpect(status().isOk());
	}
	
	
	@Test
	@Order(5)
	public void deleteRegionTestMvc () throws Exception {
		mockMvc.perform(delete("/api/region/{id}"))
				.andExpect(status().isOk());
		
	}

}


