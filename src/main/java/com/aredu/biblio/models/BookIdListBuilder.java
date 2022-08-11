package com.aredu.biblio.models;

import java.util.ArrayList;
import java.util.List;



public class BookIdListBuilder {

	private List<String> bookIdList;

	private String isbn;
	private int numberOfCopies = 1;
	
	
	
	public static BookIdListBuilder builder() {
		return new BookIdListBuilder();
	}
	
	public BookIdListBuilder addIsbn(String isbn) {

		this.isbn = isbn;
		return this;
	}
	
	public BookIdListBuilder addNumberOfCopies(int numberOfCopies) {
		if(numberOfCopies < 1) throw new IllegalArgumentException("Número de cópias inválido");
		this.numberOfCopies = numberOfCopies;
		return this;
	}
	
	private List<String> generateIds(){
		if(this.isbn == "" || this.isbn == null) this.isbn = getRandomId();
		if(this.numberOfCopies == 0) this.numberOfCopies = 1;
		List<String> resultList = new ArrayList<String>();
		for (int x=1; x <= this.numberOfCopies; x++ ) {
			String result = this.isbn.concat(String.valueOf(x));
			resultList.add(result);
		}
		return resultList;
	}

	private String getRandomId(){

		long getBaseNum = System.currentTimeMillis();
		return String.valueOf(getBaseNum).substring(3,13);

	}
	
	public List<String> get() {
		generateIds();
		//this.bookIdList = new ArrayList<String>(generateIds());
		this.bookIdList = new BookIdList(generateIds()).get();
		return this.bookIdList;
	}

	
}
