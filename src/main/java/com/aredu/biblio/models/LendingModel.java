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
	@ManyToOne
	private BookModel book;
	@ManyToOne
	private StudentModel student;
	private LocalDate dateOfLending;
	private LocalDate dateOfDevolution;
	private StatusLendingEnum status;

}
