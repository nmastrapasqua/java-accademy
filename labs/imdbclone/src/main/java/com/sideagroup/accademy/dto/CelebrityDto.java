package com.sideagroup.accademy.dto;

import java.util.ArrayList;
import java.util.List;

public class CelebrityDto {
    private String id;
    private String name;
    private Integer birthYear;
    private Integer deathYear;
    private List<MovieCelebrityDto> movies;

    public CelebrityDto() {
        movies = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<MovieCelebrityDto> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieCelebrityDto> movies) {
        this.movies = movies;
    }
}
