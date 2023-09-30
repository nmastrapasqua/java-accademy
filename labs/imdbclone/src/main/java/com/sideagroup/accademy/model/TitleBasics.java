package com.sideagroup.accademy.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "title_basics")
public class TitleBasics {

    @Id
    @Column(name = "tconst", length = 200)
    private String id;
    @Column(length = 1000, nullable = false)
    private String title;
    private Integer year;
    private Integer runtimeMinutes;
    @Column(length = 1000)
    private String genres;

    @OneToMany(mappedBy = "titleBasics")
    private Set<TitlePrincipals> names;

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

    public Set<TitlePrincipals> getNames() {
        return names;
    }

    public void setNames(Set<TitlePrincipals> names) {
        this.names = names;
    }
}
