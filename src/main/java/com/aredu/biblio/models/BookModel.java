package com.aredu.biblio.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_book")
public class BookModel implements Comparable<Object>, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, length = 50 )
	private String isbn;

	private String bookCode;
	
	@Column(nullable = false, length = 80)
	private String title;
	private String obs;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryModel category;
	private boolean avaliable = true;
	
	public BookModel() {};
	
	public BookModel(String isbn, String bookCode, String title, String obs, CategoryModel category) {
		super();
		this.isbn = isbn;
		this.bookCode = bookCode;
		this.title = title;
		this.obs = obs;
		this.category = category;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookCode() {
		return bookCode;
	}

	@Override
	public String toString() {
		return this.title;
	}

	
	public Long getId() {
		return id;
	}
	
	
	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}
	
	public CategoryModel getCategory() {
		return category;
	}

	
	public String getObs() {
		return obs;
	}
	
	public boolean isAvaliable() {
		return avaliable;
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



	public void setAvaliable(boolean avaliable) {
		this.avaliable = avaliable;
	}
	

	@Override
	public boolean equals(Object obj) {
		
		boolean result = false;
		if(this.getId() == ((BookModel)obj).getId()){
			result = true;
		}
		
		return result;
		
	}

	@Override
	public int compareTo(Object o) {
		return this.title.compareTo(((BookModel)o).toString());
			
	}
	
	
	
	
}
