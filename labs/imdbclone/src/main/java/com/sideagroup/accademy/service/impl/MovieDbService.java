package com.sideagroup.accademy.service.impl;

import com.sideagroup.accademy.dto.MovieDto;

import java.util.ArrayList;
import java.util.Optional;

public class MovieDbService {

    public Iterable<MovieDto> getAll() {
        return new ArrayList<>();
    }

    public Optional<MovieDto> getById(long id) {
        return Optional.empty();
    }

    public MovieDto create(MovieDto movie) {
        return null;
    }

    public Optional<MovieDto> update(long id, MovieDto movie) {
        return Optional.empty();
    }

    public boolean deleteById(long id) {
        return false;
    }
}
