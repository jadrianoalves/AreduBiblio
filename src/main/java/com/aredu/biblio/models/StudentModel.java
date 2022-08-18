package com.aredu.biblio.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "tb_student")
public class StudentModel implements Serializable {

	private final long serialVersionUID = 1L;

	@Id
	private long id;
	private String name;
	private long enrollmentId;
	private String classroom;
	private boolean active;
	@OneToMany
	private List<LendingModel> lendingModelList;

	public StudentModel() {
	}

	public StudentModel(long id, String name, long enrollmentId, String classroom) {
		this.id = id;
		this.name = name;
		this.enrollmentId = enrollmentId;
		this.classroom = classroom;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getEnrollmentId() {
		return enrollmentId;
	}

	public boolean isActive(){
		return active;
	}

	public void setEnrollmentId(long enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StudentModel that = (StudentModel) o;
		return id == that.id && Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	public String toString(){
		return this.name + " - " + this.classroom;
	}
}
