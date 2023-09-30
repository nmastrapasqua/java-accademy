package com.sideagroup.accademy.dto;

import java.util.ArrayList;
import java.util.List;

public class MovieDto {
    private String id;
    private String title;
    private int year;
    private int runningTime;

    private String genres;

    private List<MovieCelebrityDto> cast = new ArrayList<>();

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
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
}
