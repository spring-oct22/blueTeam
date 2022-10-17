package com.gft.wineServices;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gft.wine.Region;
import com.gft.wineRepositories.RegionRepository;

@Service
public class RegionService {
	
	@Autowired
	private RegionRepository regionRepository;	
	
	//Find All	-GET
	public List<Region> findAllRegions() {			
		return regionRepository.findAll();
	}

	//Find by ID -GET
	public Region findOneRegion (Integer id) {		
		return regionRepository.findById(id).get();
	}
	
	//Create - POST
	public	Region newRegion (Region region) {
		return regionRepository.save(region);
	}
			
	//Delete - DELETE
	
	public  Region deleteMyRegion(Integer id) {
		Region region = regionRepository.findById(id).get();
		regionRepository.deleteById(id);
		return region;
	}	
	//Modify - PUT
	public Region changeRegion(Region region, Integer id) {
		
		Region changedRegion = regionRepository.findById(id).get();		
		
		changedRegion.setId(region.getId());
		changedRegion.setName(region.getName());
		changedRegion.setCountry(region.getCountry());
		
		return regionRepository.save(changedRegion);		
		
	}	
	

}
