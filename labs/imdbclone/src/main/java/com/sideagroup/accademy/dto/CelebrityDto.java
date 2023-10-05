package com.sideagroup.accademy.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CelebrityDto {
    private String id;
    private String name;
    private Integer birthYear;
    private Integer deathYear;
    private List<MovieCelebrityDto> movies;

    public CelebrityDto() {
        movies = new ArrayList<>();
    }

}
