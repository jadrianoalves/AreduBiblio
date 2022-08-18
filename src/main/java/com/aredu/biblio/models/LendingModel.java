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
	private long id;

	private String bookCode;
	@ManyToOne
	private StudentModel student;
	private LocalDate dateOfLending;
	private LocalDate dateOfDevolution;
	private StatusLendingEnum status;


	private LendingModel(Builder builder){
		this.bookCode = builder.getBookCode();
		this.student = builder.getStudent();
		this.dateOfLending = builder.getDateOfLending();
		this.dateOfDevolution = builder.getDateOfDevolution();
		this.status = builder.getStatus();
	}

	public static class Builder{

		private String bookCode;
		private StudentModel student;
		private LocalDate dateOfLending;
		private LocalDate dateOfDevolution;
		private StatusLendingEnum status;



		private String getBookCode() {
			return bookCode;
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
