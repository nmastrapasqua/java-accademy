package com.sideagroup.accademy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ActorDto {
    private long id;
    private String firstName;
    private String lastName;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
