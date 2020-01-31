package com.wildCircus.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Performances {

	
	@Id
	private String name;
	private String photo;
	private String description;
	
	public Performances() {
		super();
	}

	public Performances(String name, String photo, String description) {
		super();
		this.photo = photo;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	
	
}
