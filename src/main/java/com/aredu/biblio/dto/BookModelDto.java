package com.aredu.biblio.dto;

import java.util.Locale.Category;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.aredu.biblio.validation.constrain.Isbn;

public class BookModelDto {
	

	@NotBlank
	@Isbn
	private String isbn;
	@NotBlank
	@Size(max = 80)
	private String title;
	private String obs;
	private Long category;
	
		
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return this.title;
	}
	public Long getCategory() {
		return this.category;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	
	public void setCategory(Long category) {
		this.category = category;
	}
		

}
