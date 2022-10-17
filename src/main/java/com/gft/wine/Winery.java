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
public class Winery {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;
	@NotNull
	@NotBlank
    private String name;
    
    @OneToMany (mappedBy = "winery")
    Set<Wine> wines;
    
    public Winery() {}

	public Winery(int id, String name, Set<Wine> wines) {
		super();
		this.id = id;
		this.name = name;
		this.wines = wines;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "[id=" + id + ", name=" + name + "]";
	}

	
	
}
