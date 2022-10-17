package com.gft.wine;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Region {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	@NotNull
	private Integer id;	
	@NotNull
	@NotBlank
	private String name;
	@NotNull
	private String country;
	
	@OneToMany(mappedBy = "region")
    Set<Wine> wines;
    
    public Region () {}   
    

	public Region(Integer id, String name, String country, Set<Wine> wines) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.wines = wines;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}


	@JsonBackReference
	public Set<Wine> getWines() {
		return wines;
	}



	public void setWines(Set<Wine> wines) {
		this.wines = wines;
	}



	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", country=" + country + "]";
	}
    
    
    
}
