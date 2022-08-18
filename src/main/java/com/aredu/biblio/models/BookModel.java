package com.aredu.biblio.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_book")
public class BookModel implements Serializable {

	private static final Long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String isbn;
	private String bookCode;
	private String title;
	private String obs;
	private int copyNumber = 0;
	private boolean available = true;
	private List<>

	public BookModel(){}
	private BookModel(Builder builder){
		this.isbn = builder.isbn;
		this.bookCode = builder.bookCode;
		this.title = builder.title;
		this.copyNumber = builder.copyNumber;
	}

	public Long getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getBookCode() {
		return bookCode;
	}

	public String getTitle() {
		return title;
	}

	public String getObs() {
		return obs;
	}

	public int getCopyNumber() {
		return copyNumber;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setCopyNumber(int copyNumber) {
		this.copyNumber = copyNumber;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public static class Builder {

		private String isbn;
		private String bookCode;
		private String title;
		private String obs;
		private int copyNumber;

		public Builder(){};
		public Builder(String isbn, String bookCode, String title, String obs, int copyNumber) {
			this.isbn = isbn;
			this.bookCode = bookCode;
			this.title = title;
			this.obs = obs;
			this.copyNumber = copyNumber;
		}

		public Builder addBookCode(String bookCode){
			this.bookCode = bookCode;
			return this;
		}

		public Builder addIsbn (String isbn){
			this.isbn = isbn;
			return this;
		}

		public Builder addTitle (String title){
			this.title = title;
			return this;
		}

		public Builder addObs (String obs){
			this.obs = obs;
			return this;
		}

		public Builder addCopyNumber(int copyNumber){
			this.copyNumber = copyNumber;
			return this;
		}

		public BookModel build(){
			return new BookModel(this);
		}


	}

	}


