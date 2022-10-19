package com.gft.wine;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table (name = "type")
public class Type {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@NotNull
	private Integer id;
	@NotNull
	@NotBlank
    private String name;
	  
    @OneToMany (mappedBy = "type")
    Set<Wine> wines;
    
    public Type () {}

	public Type(@NotNull Integer id, @NotNull @NotBlank String name, Set<Wine> wines) {
		super();
		this.id = id;
		this.name = name;
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

	public Set<Wine> getWines() {
		return wines;
	}
	@JsonBackReference
	public void setWines(Set<Wine> wines) {
		this.wines = wines;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + ", wines=" + wines + "]";
	}

	
    
}
