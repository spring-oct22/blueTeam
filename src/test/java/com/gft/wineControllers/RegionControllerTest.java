package com.gft.wineControllers;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.gft.wine.Region;


@SpringBootTest
class RegionControllerTest {

	
	@Autowired
	private RegionController regionController;
	
	@Test
	public void contextLoads() throws Exception {
		
		assertThat (regionController). isNotNull();		
		
	}
	
	@Test
	public void regionCrudTesting () {
		
		List<Region> allRegions = regionController.allRegions();
		
		
		//Find All - GET
		Assertions.assertThat(allRegions.size()).isGreaterThan(0);	
		
		//Find by Id - GET
		Region region = regionController.getRegionById(4);
		Assertions.assertThat(region.getId().equals(4));
		
	
		//Create - POST		
		Region region2 = new Region();
		region2.setId(80);
		region2.setName("Mi region");
		region2.setCountry("España");
		
		Region newRegion = regionController.postRegion(region2);
		Integer newId = newRegion.getId();
		Assertions.assertThat(newRegion.getId()).isGreaterThan(0);		
		
		//Update - PUT		
		newRegion.setName("Mi region2");	
		Region changedRegion = regionController.putRegion(newRegion, newId);
		Assertions.assertThat(changedRegion.getName()).isEqualTo("Mi region2");		
				
		//Delete - DELETE		
		Region regionDeleted = regionController.getRegionById(newId);
		regionController.deleteRegion(newId);
		
		Assertions.assertThat(regionDeleted).isNotIn(allRegions);
		
	}	

}
