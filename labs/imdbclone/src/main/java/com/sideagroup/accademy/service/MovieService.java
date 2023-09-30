package com.sideagroup.accademy.service;

import com.sideagroup.accademy.dto.GetAllMovieResponseDto;
import com.sideagroup.accademy.dto.MovieDto;
import java.util.Optional;

public interface MovieService {

    public GetAllMovieResponseDto getAll(int page, int size, String orderBy);

    public Optional<MovieDto> getById(String id);

    public MovieDto create(MovieDto movie);

    public Optional<MovieDto> update(String id, MovieDto movie);

    public boolean deleteById(String id);
}
