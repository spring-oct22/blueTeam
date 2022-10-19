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
import com.gft.wine.Wine;
import com.gft.wineServices.WineService;

@RestController

public class WineController {
	
	
	@Autowired
	private WineService wineService;
	
	
	@GetMapping ("/wines")	
	public List<Wine> allWines (){		
		
		return wineService.findAllWines();
	}
	
	@GetMapping ("/api/wine/{id}")
	public Wine getWineById(@PathVariable Integer id) {
		
		Wine wine= wineService.findOneWine(id);			
			
		return wine;			
	}	
	
	@PostMapping ("/api/wine")
	public Wine postWine(@RequestBody Wine wine ) {
			
		return wineService.newWine(wine);
	}
	
	@PutMapping("/api/wine/{id}")
	public Wine putWine(@RequestBody Wine wine, @PathVariable Integer id) {	
		
		return wineService.changeWine(wine,id);		
		
	}
	
	@DeleteMapping ("/api/wine/{id}")
	public void deleteWine(@PathVariable Integer id) {
		wineService.deleteMyWine(id);
		
	}
	
	
	
		
}
