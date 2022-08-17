package com.aredu.biblio.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class BookModelDto {

	private String isbn;
	@NotBlank
	@Size(max = 80)
	private String title;
	private String obs;
	private int numberOfCopies;

	public BookModelDto() {
	}

	public BookModelDto(String isbn, String title, String obs, int numberOfCopies) {
		this.isbn = isbn;
		this.title = title;
		this.obs = obs;
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

	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}



	




	



	

		

}
