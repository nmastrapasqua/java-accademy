package com.sideagroup.accademy.dto;

import java.util.ArrayList;
import java.util.List;

public class GetAllMoviesResponseDto {

    private PaginationDto pagination;
    private List<MovieDto> movies;

    public GetAllMoviesResponseDto() {
        pagination = new PaginationDto();
        movies = new ArrayList<>();
    }

    public PaginationDto getPagination() {
        return pagination;
    }

    public void setPagination(PaginationDto pagination) {
        this.pagination = pagination;
    }

    public List<MovieDto> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDto> movies) {
        this.movies = movies;
    }
}
