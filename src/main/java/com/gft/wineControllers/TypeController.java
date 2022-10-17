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
import com.gft.wine.Type;
import com.gft.wineServices.TypeService;


@RestController
public class TypeController {
	
	@Autowired
	private TypeService typeService;
	
	@GetMapping ("/types")	
	public List<Type> allTypes (){		
		
		return typeService.findAllTypes();
	}
	
	@GetMapping ("/api/type/{id}")
	public Type getTypeById(@PathVariable Integer id) {
		
		Type type= typeService.findOneType(id);			
			
		return type;	
		
	}	
	
	@PostMapping ("/api/type/{id}")
	public Type postType(@RequestBody Type type ) {
			
		return typeService.newType(type);
	}
	
	@PutMapping("/api/type/{id}")
	public Type putType(@RequestBody Type type, @PathVariable Integer id) {	
		
		return typeService.changeType(type,id);		
		
	}
	
	@DeleteMapping ("/api/type/{id}")
	public void deleteType(@PathVariable Integer id) {
		typeService.deleteMyType(id);
		
	}
}
