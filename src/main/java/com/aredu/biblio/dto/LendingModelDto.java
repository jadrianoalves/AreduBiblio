package com.aredu.biblio.dto;

import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.models.StudentModel;

public class LendingModelDto {

    private StudentModel student;
    private String bookCode;
    private BookModel bookModel;

    public LendingModelDto() {
    }

    public LendingModelDto(StudentModel student, String bookCode) {
        this.student = student;
        this.bookCode = bookCode;
    }

    public StudentModel getStudent() {
        return student;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }

    public String getBookCode() {
        return bookCode;
    }

    public BookModel getBookModel() {
        return bookModel;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public void setBook(BookModel book) {
        this.bookModel = book;
    }
}
