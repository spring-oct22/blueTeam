package com.gft.wineControllers;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.gft.wine.Wine;

@SpringBootTest
class WineControllerTest {

	@Autowired
	private WineController wineController;
	
	@Test
	public void contextLoads() throws Exception {
		
		assertThat (wineController). isNotNull();		
		
	}
	
	@Test
	public void wineCrudTesting () {
		
		List<Wine> allWines = wineController.allWines();
		
		//Find All - GET
		Assertions.assertThat(allWines.size()).isGreaterThan(0);
		
		//Find by Id - GET
		Wine wine = wineController.getWineById(270);
		Assertions.assertThat(wine.getId().equals(270));
	
		//Create - POST		
		Wine wine2 = new Wine();
		wine2.setId(7011);
		wine2.setName("Mi vino");
		wine2.setYear("2022");
		wine2.setRating(5D);
		wine2.setNum_reviews(3);
		wine2.setPrice(200D);
		wine2.setBody("4");
		wine2.setAcidity("2");
		wine2.setWinery(null);
		wine2.setType(null);
		wine2.setRegion(null);
			
		Wine newWine = wineController.postWine(wine2);
		Integer newId = newWine.getId();
		Assertions.assertThat(newWine.getId()).isGreaterThan(0);
		
		
		//Update - PUT		
		newWine.setName("Mi vino2");		
		Wine changedWine = wineController.putWine(newWine, newId);
		Assertions.assertThat(changedWine.getName()).isEqualTo("Mi vino2");
		
		
		//Delete - DELETE
		Wine wineDeleted = 	wineController.getWineById(newId);
		wineController.deleteWine(newId);		
		Assertions.assertThat(wineDeleted).isNotIn(allWines);
	}
	


}
