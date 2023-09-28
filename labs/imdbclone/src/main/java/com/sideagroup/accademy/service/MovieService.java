package com.sideagroup.accademy.service;

import com.sideagroup.accademy.dto.MovieDto;
import java.util.Optional;

public interface MovieService {

    public Iterable<MovieDto> getAll();

    public Optional<MovieDto> getById(long id);

    public MovieDto create(MovieDto movie);

    public Optional<MovieDto> update(long id, MovieDto movie);

    public boolean deleteById(long id);
}
