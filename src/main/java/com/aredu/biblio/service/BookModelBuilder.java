package com.aredu.biblio.service;

import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.models.CategoryModel;

import java.util.ArrayList;
import java.util.List;


public class BookModelBuilder {



    private String isbn;
    private String title;
    private int numberOfCopies = 1;
    private CategoryModel category;

    private int lastNumberOfCopy;

    public void setLastNumberOfCopy(int lastNumberOfCopy) {
        this.lastNumberOfCopy = lastNumberOfCopy;
    }


    private BookModelBuilder(String title){
        if(title.isEmpty()) throw new IllegalArgumentException("Título não pode ser vazio");
        this.title = title;

    }
    public static BookModelBuilder builder(String title){
      return new BookModelBuilder(title);
    }
    public BookModelBuilder addIsbn(String isbn){
        if(isbn !="" & !isbn.matches("[0-9]{10}") ) throw new IllegalArgumentException("Isbn inválido");
        this.isbn = isbn;
        return this;
    }
    public BookModelBuilder addNumberOfCopies(int numberOfCopies){
        if(numberOfCopies < 1) throw new IllegalArgumentException("Número de cópias inválido");
        this.numberOfCopies = numberOfCopies;
        return this;
    }

    public BookModelBuilder addCategory(CategoryModel category) {
        this.category = category;
        return this;
    }
    private List<BookModel> generateBooksList (List<BookCode> bookIdList){
        List<BookCode> bookList = generateIds();
        List<BookModel> books = new ArrayList<BookModel>();

        bookList.stream()
                .forEach((bookCod)->
                    books.add(new BookModel(this.isbn, bookCod.getBookCode(), bookCod.numberOfCopy,  this.title, "", this.category))
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

    private List<BookCode> generateIds(){
        String baseIsbn = "";
        List<BookCode> booksCodes = new ArrayList<BookCode>();
        int baseNumberOfCopy = this.lastNumberOfCopy;
        if(this.isbn == "" || this.isbn == null) baseIsbn = getRandomId(); else baseIsbn = this.isbn;
        if(this.numberOfCopies == 0) this.numberOfCopies = 1;

        for (int x=baseNumberOfCopy; x <= this.numberOfCopies; x++ ) {
            BookCode newBook = new BookCode();
            //String result = baseIsbn.concat(String.valueOf(x));
            newBook.setBookCode(baseIsbn.concat(String.valueOf(x)));
            newBook.setNumberOfCopy(x);
            booksCodes.add(newBook);

        }
        return booksCodes;
    }




    private class BookCode{

        private int numberOfCopy;
        private String bookCode;

        public int getNumberOfCopy(){
            return this.numberOfCopy;
        }

        public String getBookCode(){
            return this.bookCode;
        }

        public void setNumberOfCopy(int numberOfCopy) {
            this.numberOfCopy = numberOfCopy;
        }
        public void setBookCode(String bookCode) {
            this.bookCode = bookCode;
        }




    }

}
