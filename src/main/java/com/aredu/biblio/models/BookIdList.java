package com.aredu.biblio.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookIdList extends ArrayList<String>{
	
	private List<String> bookIdList;
	
	public BookIdList(List<String> bookIdList) {
		this.bookIdList = bookIdList;
	}
	
	public int size() {
		return this.bookIdList.size();
	}
	
	public List<String> get() {
		return this.bookIdList;
	}
	
	public String get(int position) {
		return this.bookIdList.get(position);
	}


	
}
