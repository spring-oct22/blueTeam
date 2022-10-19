package com.gft.wineControllers;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.gft.wine.Winery;

@SpringBootTest
class WineryControllerTest {

	@Autowired
	private WineryController wineryController;
	
	@Test
	public void contextLoads() throws Exception {
		
		assertThat (wineryController). isNotNull();		
		
	}
	
	@Test
	public void wineCrudTesting () {
		
		List<Winery> allWineries = wineryController.allWineries();		
		
		//Find All - GET
		Assertions.assertThat(allWineries.size()).isGreaterThan(0);
		
		//Find by Id - GET
		Winery winery = wineryController.getWineryById(270);
		Assertions.assertThat(winery.getId().equals(270));
	
		//Create - POST		
		Winery winery2 = new Winery();
		winery2.setId(570);
		winery2.setName("Mi bodega");
			
		Winery newWinery = wineryController.postWinery(winery2);
		Integer newId = newWinery.getId();
		Assertions.assertThat(newWinery.getId()).isGreaterThan(0);
		
		
		//Update - PUT		
		newWinery.setName("Mi bodega2");		
		Winery changedWinery = wineryController.putWinery(newWinery, newId);
		Assertions.assertThat(changedWinery.getName()).isEqualTo("Mi bodega2");
		
		
		//Delete - DELETE
		Winery wineryDeleted = wineryController.getWineryById(newId);
		wineryController.deleteWinery(newId);
		
		Assertions.assertThat(wineryDeleted).isNotIn(allWineries);
	
		
	}
	

}
