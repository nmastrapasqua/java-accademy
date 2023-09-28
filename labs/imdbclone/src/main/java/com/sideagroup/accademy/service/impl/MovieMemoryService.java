package com.sideagroup.accademy.service.impl;

import com.sideagroup.accademy.dto.MovieDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieMemoryService {
    private List<MovieDto> movies = new ArrayList<>();
    private long lastId = 0;

    public Iterable<MovieDto> getAll() {
        return movies;
    }

    public Optional<MovieDto> getById(long id) {
        Optional<MovieDto> opt = movies.stream().filter(item->item.getId() == id).findFirst();
        return opt;
    }

    public MovieDto create(MovieDto movie) {
        lastId++;
        movie.setId(lastId);
        movies.add(movie);
        return movie;
    }

    public Optional<MovieDto> update(long id, MovieDto movie) {
        Optional<MovieDto> opt = movies.stream().filter(item->item.getId() == id).findFirst();

        if (opt.isEmpty())
            return opt;

        MovieDto myMovie = opt.get();
        myMovie.setTitle(movie.getTitle());
        myMovie.setYear(movie.getYear());
        myMovie.setRunningTime(movie.getRunningTime());

        return opt;
    }

    public boolean deleteById(long id) {
        Optional<MovieDto> opt = movies.stream().filter(item->item.getId() == id).findFirst();

        if (opt.isEmpty())
            return false;

        movies.remove(opt.get());

        return true;
    }
}
