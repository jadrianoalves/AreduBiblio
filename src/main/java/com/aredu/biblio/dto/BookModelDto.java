package com.aredu.biblio.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.aredu.biblio.models.CategoryModel;
import com.aredu.biblio.validation.constrain.Isbn;

public class BookModelDto {
	



	private String isbn;
	@NotBlank
	@Size(max = 80)
	private String title;
	private String obs;
	private CategoryModel category;
	public int getNumberOfCopies() {
		return numberOfCopies;
	}

	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}

	private int numberOfCopies;

	public long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	private long categoryId;

		
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return this.title;
	}
	public CategoryModel getCategory() {
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
	
	public void setCategory(CategoryModel category) {
		this.category = category;
	}
		

}
