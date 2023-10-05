package com.sideagroup.accademy.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MovieDto {
    private String id;
    private String title;
    private Integer year;
    private Integer runningTime;
    private String genres;
    private List<MovieCelebrityDto> cast;

    public MovieDto() {
        cast = new ArrayList<>();
    }

}
