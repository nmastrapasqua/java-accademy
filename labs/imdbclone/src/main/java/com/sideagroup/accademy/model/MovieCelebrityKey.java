package com.sideagroup.accademy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MovieCelebrityKey {

    @Column(name = "nconst", length = 200)
    private String celebrityId;
    @Column(name = "tconst", length = 200)
    private String movieId;

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
