package com.sideagroup.accademy.service;

import com.sideagroup.accademy.dto.MovieDto;
import java.util.Optional;

public interface MovieService {

    public Iterable<MovieDto> getAll();

    public Optional<MovieDto> getById(String id);

    public MovieDto create(MovieDto movie);

    public Optional<MovieDto> update(String id, MovieDto movie);

    public boolean deleteById(String id);
}
