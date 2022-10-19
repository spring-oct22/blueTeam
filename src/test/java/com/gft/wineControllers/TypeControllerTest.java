package com.gft.wineControllers;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.gft.wine.Type;



@SpringBootTest
class TypeControllerTest {

	@Autowired
	private TypeController typeController;
	
	@Test
	public void contextLoads() throws Exception {
		
		assertThat (typeController). isNotNull();	
	}
		
	@Test
	public void typeCrudTesting () {
		
		List<Type> allTypes = typeController.allTypes();		
		
		//Find All - GET
		Assertions.assertThat(allTypes.size()).isGreaterThan(0);
		
		//Find by Id - GET
		Type type = typeController.getTypeById(9);
		Assertions.assertThat(type.getId().equals(9));
	
		//Create - POST		
		Type type2 = new Type();
		type2.setId(570);
		type2.setName("Mi tipo");
			
		Type newType = typeController.postType(type2);
		Integer newId = newType.getId();
		Assertions.assertThat(newType.getId()).isGreaterThan(0);
		
		
		//Update - PUT		
		newType.setName("Mi tipo2");		
		Type changedType = typeController.putType(newType, newId);
		Assertions.assertThat(changedType.getName()).isEqualTo("Mi tipo2");
		
		
		//Delete - DELETE
		Type typeDeleted = typeController.getTypeById(newId);
		typeController.deleteType(newId);
		
		Assertions.assertThat(typeDeleted).isNotIn(allTypes);
	
		
	}
}	


