package com.gft.wineRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.wine.Wine;

@Repository
public interface WineRepository extends JpaRepository <Wine,Integer> {

}


