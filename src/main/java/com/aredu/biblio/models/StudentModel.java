package com.aredu.biblio.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentModel implements Serializable {
	public StudentModel() {

	}

	private final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String name;
	private String classroom;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	private boolean active;

	public StudentModel(int id, String name, String classroom) {
		this.id = id;
		this.name = name;
		this.classroom = classroom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
}
