package com.aredu.biblio.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.aredu.biblio.models.CategoryModel;

public class BookModelDto {

	private String isbn;
	@NotBlank
	@Size(max = 80)
	private String title;
	private String obs;
	private CategoryModel category;
	private long categoryId;
	private int numberOfCopies;

	public BookModelDto() {
	}

	public BookModelDto(String isbn, String title, String obs, long categoryId, int numberOfCopies) {
		this.isbn = isbn;
		this.title = title;
		this.obs = obs;
		this.categoryId = categoryId;
		this.numberOfCopies = numberOfCopies;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return this.title;
	}

	public String getObs() {
		return obs;
	}

	public CategoryModel getCategory() {
		return this.category;
	}

	public long getCategoryId() {
		return this.categoryId;
	}

	public int getNumberOfCopies() {
		return numberOfCopies;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public void setObs(String obs) {
		this.obs = obs;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}


	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}



	




	



	

		

}
