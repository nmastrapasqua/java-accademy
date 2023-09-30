package com.sideagroup.accademy.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="celebrity")
public class Celebrity {
    @Id
    @Column(length = 200)
    private String id;

    @Column(length = 1000, nullable = false)
    private String primaryName;
    private Integer birthYear;
    private Integer deathYear;

    @OneToMany(mappedBy = "celebrity")
    private Set<MovieCelebrity> titles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public Set<MovieCelebrity> getTitles() {
        return titles;
    }

    public void setTitles(Set<MovieCelebrity> titles) {
        this.titles = titles;
    }
}
