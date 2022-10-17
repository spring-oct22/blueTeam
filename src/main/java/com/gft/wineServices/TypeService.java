package com.gft.wineServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gft.wine.Type;
import com.gft.wineRepositories.TypeRepository;

@Service
public class TypeService {

	@Autowired
	private TypeRepository typeRepository;
	
	
	//Find All 	-GET
	public List<Type> findAllTypes() {			
		return typeRepository.findAll();
		}

	//Find by ID - GET
	public Type findOneType (Integer id) {		
		return typeRepository.findById(id).get();
	}
	
	//Create - POST
	public	Type newType (Type type) {
		return typeRepository.save(type);
	}
	
	//Modify - PUT
	public Type changeType(Type type, Integer id) {
		
		Type changedType = typeRepository.findById(id).get();		
		
		changedType.setId(type.getId());
		changedType.setName(type.getName());
		
		return typeRepository.save(changedType);		
		
	}
	
	//Delete - DELETE
	
	public  Type deleteMyType(Integer id) {
		Type type = typeRepository.findById(id).get();
		typeRepository.deleteById(id);
		return type;
		}
		
}
