package com.aredu.biblio.service;

import com.aredu.biblio.models.BookCode;
import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.models.CategoryModel;

import java.util.ArrayList;
import java.util.List;


public class BookModelBuilder {

    private String isbn;
    private String title;
    private int numberOfCopies = 1;
    private CategoryModel category;

    private BookCode bookCode;
    private int lastNumberOfCopy;

    private BookModelBuilder(String title, BookCode bookCode, CategoryModel category){
        if(title.isEmpty()) throw new IllegalArgumentException("Título não pode ser vazio");
        this.title = title;
        this.bookCode = bookCode;
        this.category = category;
    }
    public static BookModelBuilder builder(String title, BookCode bookCode, CategoryModel category){
      return new BookModelBuilder(title, bookCode, category);
    }

    public BookModelBuilder addNumberOfCopies(int numberOfCopies){
        if(numberOfCopies < 1) throw new IllegalArgumentException("Número de cópias inválido");
        this.numberOfCopies = numberOfCopies;
        return this;
    }

    public BookModelBuilder addIsbn(String isbn){
        this.isbn = isbn;
        return this;
    }

    private List<BookModel> generateBooksList (){
        List<BookCode> bookCodesList = generateIds(this.bookCode);
        List<BookModel> books = new ArrayList<BookModel>();

        bookCodesList.stream()
                .forEach((bookCod)->
                    books.add(new BookModel(this.isbn, bookCod.getBookCode(), bookCod.getNumberOfCopy(),  this.title, "", this.category))
                );
            return books;
    }

    public List<BookModel> get(){

        return generateBooksList();

    }

    private List<BookCode> generateIds(BookCode bookCode){

        List<BookCode> booksCodes = new ArrayList<BookCode>();
        int baseNumberOfCopy = bookCode.getNumberOfCopy();

        for (int x=baseNumberOfCopy; x <= this.numberOfCopies; x++ ) {
            BookCode newBook = new BookCode();
            newBook.setBookCode(bookCode.getBookCode().concat(String.valueOf(x)));
            newBook.setNumberOfCopy(x);
            booksCodes.add(newBook);
        }
        return booksCodes;
    }






}
