package com.aredu.biblio.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name="tb_lending")
public class LendingModel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private BookModel book;
	private String bookCode;
	@ManyToOne
	private StudentModel student;
	private LocalDate dateOfLending;
	private LocalDate dateOfDevolution;
	private LocalDate dateOfReturned;
	private StatusLendingEnum status;

	public LendingModel(){}

	public Long getId() {
		return id;
	}

	public String getBookCode() {
		return bookCode;
	}

	public BookModel getBook(){
		return book;
	}

	public StudentModel getStudent() {
		return student;
	}

	public LocalDate getDateOfLending() {
		return dateOfLending;
	}

	public LocalDate getDateOfDevolution() {
		return dateOfDevolution;
	}

	public LocalDate getDateOfReturned() {
		return dateOfReturned;
	}


	public StatusLendingEnum getStatus() {
		return status;
	}


	public void setDateOfReturned(LocalDate dateOfReturned){
		this.dateOfReturned = dateOfReturned;
	}

	private LendingModel(Builder builder){
		this.bookCode = builder.getBookCode();
		this.book = builder.getBook();
		this.student = builder.getStudent();
		this.dateOfLending = builder.getDateOfLending();
		this.dateOfDevolution = builder.getDateOfDevolution();
		this.status = builder.getStatus();
	}



	public static class Builder{

		private String bookCode;
		private BookModel book;
		private StudentModel student;
		private LocalDate dateOfLending;
		private LocalDate dateOfDevolution;
		private StatusLendingEnum status;



		private String getBookCode() {
			return bookCode;
		}

		private BookModel getBook() {
			return book;
		}

		private StudentModel getStudent() {
			return student;
		}

		private LocalDate getDateOfLending() {
			return dateOfLending;
		}

		private LocalDate getDateOfDevolution() {
			return dateOfDevolution;
		}

		private StatusLendingEnum getStatus() {
			return status;
		}

		public Builder addBookCode(String bookCode){
			this.bookCode = bookCode;
			return this;
		}

		public Builder addBook(BookModel bookModel){
			this.book = bookModel;
			return this;
		}

		public Builder addStudent(StudentModel studentModel){
			this.student = studentModel;
			return this;
		}

		public Builder addDateOfLending(LocalDate date){
			this.dateOfLending = date;
			return this;
		}

		public Builder addDateOfDevolution(LocalDate date){
			this.dateOfDevolution = date;
			return this;
		}

		public Builder addStatus( StatusLendingEnum status) {
			this.status = status;
			return this;
		}

		public LendingModel build(){
			return new LendingModel(this);
		}


	}

}
