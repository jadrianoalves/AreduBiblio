package com.aredu.biblio.dto;


import javax.persistence.Id;
import java.util.Objects;

public class StudentModelDto {

    private long id;
    private String name;
    private long enrollmentId;
    private String classroom;

    public StudentModelDto() {
    }

    public StudentModelDto(long id, String name, long enrollmentId, String classroom) {
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

    public void setEnrollmentId(long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

}
