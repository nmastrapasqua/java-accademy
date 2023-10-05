package com.sideagroup.accademy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
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

}
