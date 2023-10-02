package com.sideagroup.accademy.service.impl;

import com.sideagroup.accademy.dto.MovieDto;
import com.sideagroup.accademy.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
//@Service("mainMovieService")
public class MovieDbService implements MovieService {

    @Override
    public Iterable<MovieDto> getAll() {
        return new ArrayList<>();
    }

    @Override
    public Optional<MovieDto> getById(String id) {
        return Optional.empty();
    }

    @Override
    public MovieDto create(MovieDto movie) {
        return null;
    }

    @Override
    public Optional<MovieDto> update(String id, MovieDto movie) {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }
}
