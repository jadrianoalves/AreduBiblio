package com.aredu.biblio.dto;

import javax.validation.constraints.NotBlank;

public class CategoryModelDto {
	
	
	@NotBlank
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
