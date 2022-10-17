package com.gft.wineRepositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.wine.Winery;

public interface WineryRepository extends JpaRepository <Winery, Integer>{
	
	

}
