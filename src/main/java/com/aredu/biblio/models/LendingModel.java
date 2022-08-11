package com.aredu.biblio.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_lending")
public class LendingModel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@OneToOne
	private BookModel book;
	@OneToOne
	private StudentModel student;
	
	private LocalDate dateOfLending;
	private LocalDate dateOfDevolution;
	private boolean satus;

}
