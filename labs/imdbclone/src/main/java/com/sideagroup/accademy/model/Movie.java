package com.sideagroup.accademy.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @Column(length = 200)
    private String id;
    @Column(length = 1000, nullable = false)
    private String title;
    @Column(name = "startYear")
    private Integer year;
    private Integer runtimeMinutes;
    @Column(length = 1000)
    private String genres;

    @OneToMany(mappedBy = "movie")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<MovieCelebrity> names;

    @OneToMany(mappedBy = "movie")
    private Set<Country> countries;

    @OneToOne(mappedBy = "movie")
    private Rating rating;

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

    public Integer getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public void setRuntimeMinutes(Integer runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public Set<MovieCelebrity> getNames() {
        return names;
    }

    public void setNames(Set<MovieCelebrity> names) {
        this.names = names;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
