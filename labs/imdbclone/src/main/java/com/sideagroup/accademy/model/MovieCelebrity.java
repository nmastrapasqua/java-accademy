package com.sideagroup.accademy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_celebrity")
public class MovieCelebrity {

    @EmbeddedId
    private MovieCelebrityKey id;

    @ManyToOne
    @MapsId("celebrityId")
    private Celebrity celebrity;

    @ManyToOne
    @MapsId("movieId")
    private Movie movie;

    @Column(length = 1000)
    private String category;

    @Column(length = 1000)
    private String characters;

    public MovieCelebrity() {
        this(null);
    }

    public MovieCelebrity(MovieCelebrityKey id) {
        this.id = id;
    }

    public MovieCelebrityKey getId() {
        return id;
    }

    public void setId(MovieCelebrityKey id) {
        this.id = id;
    }

    public Celebrity getCelebrity() {
        return celebrity;
    }

    public void setCelebrity(Celebrity celebrity) {
        this.celebrity = celebrity;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
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
}
