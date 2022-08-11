package com.aredu.biblio.models;

import java.util.ArrayList;
import java.util.List;


public class BookModelBuilder {

    private String isbn;
    private String title;
    private int numberOfCopies = 1;
    private CategoryModel category;
    private boolean tempIsbn = false;

    private BookModelBuilder(String title){
        if(title.isEmpty()) throw new IllegalArgumentException("Título não pode ser vazio");
        this.title = title;
    }
    public static BookModelBuilder builder(String title){
      return new BookModelBuilder(title);
    }
    public BookModelBuilder addIsbn(String isbn){
        if(isbn !=null && !isbn.matches("[0-9]{10}") ) throw new IllegalArgumentException("Isbn inválido");
        this.isbn = isbn;
        return this;
    }
    public BookModelBuilder addNumberOfCopies(int numberOfCopies){
        if(numberOfCopies < 1) throw new IllegalArgumentException("Número de cópias inválido");
        this.numberOfCopies = numberOfCopies;
        return this;
    }
    private List<BookModel> generateBooksList (List<String> bookIdList){
        List<String> bookList = generateIds();
        List<BookModel> books = new ArrayList<BookModel>();
        bookList.stream()
                .forEach((bookCod)->
                    books.add(new BookModel(this.isbn, bookCod, this.title, "", this.category))
                );
            return books;
    }

    public List<BookModel> get(){
        List<String> bookIdList = generateIds();
        return generateBooksList(bookIdList);

    }


    private String getRandomId(){

        long getBaseNum = System.currentTimeMillis();
        return String.valueOf(getBaseNum).substring(3,13);

    }

    private List<String> generateIds(){
        String baseIsbn = "";
        if(this.isbn == "" || this.isbn == null) baseIsbn = getRandomId(); else baseIsbn = this.isbn;
        if(this.numberOfCopies == 0) this.numberOfCopies = 1;
        List<String> resultList = new ArrayList<String>();
        for (int x=1; x <= this.numberOfCopies; x++ ) {
            String result = baseIsbn.concat(String.valueOf(x));
            resultList.add(result);
        }

        return resultList;
    }


}
