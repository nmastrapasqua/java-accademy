package com.sideagroup.accademy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MovieCelebrityKey {

    @Column(length = 200)
    private String celebrityId;
    @Column(length = 200)
    private String movieId;

    public MovieCelebrityKey() {
        this(null, null);
    }

    public MovieCelebrityKey(String celebrityId, String movieId) {
        this.celebrityId = celebrityId;
        this.movieId = movieId;
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
