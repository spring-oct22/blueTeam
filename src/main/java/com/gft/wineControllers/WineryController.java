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
import com.gft.wine.Winery;
import com.gft.wineServices.WineryService;

@RestController
public class WineryController {
	
	@Autowired
	private WineryService wineryService;
	
	@GetMapping ("/wineries")	
	public List<Winery> allWineries (){		
		
		return wineryService.findAllWineries();
	}
	
	@GetMapping ("/api/winery/{id}")
	public Winery getWineryById(@PathVariable Integer id) {
		
		Winery winery= wineryService.findOneWinery(id);			
			
		return winery;				
		
	}	
	
	@PostMapping ("/api/winery/{id}")
	public Winery postWinery(@RequestBody Winery winery ) {
			
		return wineryService.newWinery(winery);
	}
	
	@PutMapping("/api/winery/{id}")
	public Winery putWinery(@RequestBody Winery winery, @PathVariable Integer id) {	
		
		return wineryService.changeWinery(winery,id);		
		
	}
	
	@DeleteMapping ("/api/winery/{id}")
	public void deleteWinery(@PathVariable Integer id) {
		wineryService.deleteMyWinery(id);
		
	}
}
