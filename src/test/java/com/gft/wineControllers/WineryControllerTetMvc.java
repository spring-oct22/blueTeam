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

import com.gft.wine.Winery;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class WineryControllerTetMvc {

	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	@Order (1)
	 public void allWineriesTestMvc() throws Exception {
		mockMvc.perform(get("/wineries")
			.contentType("application/json"))
			.andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	public void getWineryByIdTestMvc() throws Exception {
		mockMvc.perform(get("/api/winery/{id}", 30)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(30)))
				.andExpect(jsonPath("$.name", is("Martinet")));		
	}
	
	@Test
	@Order(3)
	public void postWineryTestMvc () throws Exception {
		
		mockMvc.perform(post("/api/winery" )
				.contentType("application/json")
				.content("{\"id\": 500, \"name\": \"Mi bodega de prueba\"}")				
				.accept(MediaType.APPLICATION_JSON))				
				.andExpect(status().isOk());				
	}
	
	@Test
	@Order(4)
	public void putWineryTestMvc() throws Exception{		
		mockMvc.perform(put("/api/winery/{id}")
				.contentType("application/json")
				.content("{\"id\": 500, \"name\": \"Mi bodega de prueba2\"}"))
				.andExpect(status().isOk());
	}
	
	
	@Test
	@Order(5)
	public void deleteWineryTestMvc () throws Exception {
		mockMvc.perform(delete("/api/winery/{id}"))
				.andExpect(status().isOk());
		
	}

}
