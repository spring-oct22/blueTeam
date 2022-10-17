package com.gft.wineControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.gft.wine.Region;
import com.gft.wineServices.RegionService;


@RestController
public class RegionController {
	
	@Autowired
	private RegionService regionService;
	
	@GetMapping ("/regions")	
	public List<Region> allRegions (){		
		
		return regionService.findAllRegions();
	}
	
	@GetMapping ("/api/region/{id}")
	public Region getRegionById(@PathVariable Integer id) {
		
		Region region= regionService.findOneRegion(id);			
			
		return region;			
	}	
	
	@PostMapping ("/api/region/{id}")
	public Region postRegion(@RequestBody Region region ) {
			
		return regionService.newRegion(region);
	}
	
	@PutMapping("/api/region/{id}")
	public Region putRegion(@RequestBody Region region, @PathVariable Integer id) {	
		
		return regionService.changeRegion(region,id);		
		
	}
	
	@DeleteMapping ("/api/region/{id}")
	public void deleteRegion(@PathVariable Integer id) {
		regionService.deleteMyRegion(id);
		
	}
}
