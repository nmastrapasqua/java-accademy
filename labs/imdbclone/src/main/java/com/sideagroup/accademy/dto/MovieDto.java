package com.sideagroup.accademy.dto;

import java.util.ArrayList;
import java.util.List;

public class MovieDto {
    private String id;
    private String title;
    private Integer year;
    private Integer runningTime;
    private String genres;
    private List<MovieCelebrityDto> cast;
    private RatingDto rating;
    private List<CountryDto> country;

    public MovieDto() {
        cast = new ArrayList<>();
        country = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(Integer runningTime) {
        this.runningTime = runningTime;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public List<MovieCelebrityDto> getCast() {
        return cast;
    }

    public void setCast(List<MovieCelebrityDto> cast) {
        this.cast = cast;
    }

    public RatingDto getRating() {
        return rating;
    }

    public void setRating(RatingDto rating) {
        this.rating = rating;
    }

    public List<CountryDto> getCountry() {
        return country;
    }

    public void setCountry(List<CountryDto> country) {
        this.country = country;
    }
}
