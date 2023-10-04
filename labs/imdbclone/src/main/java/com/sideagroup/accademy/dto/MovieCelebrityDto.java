package com.sideagroup.accademy.dto;

public class MovieCelebrityDto {

    private String celebrityName;
    private String celebrityId;
    private String movieTitle;
    private String movieId;
    private String category;
    private String characters;


    public String getCelebrityName() {
        return celebrityName;
    }

    public void setCelebrityName(String celebrityName) {
        this.celebrityName = celebrityName;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    public String getCelebrityId() {
        return celebrityId;
    }

    public void setCelebrityId(String celebrityId) {
        this.celebrityId = celebrityId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}

