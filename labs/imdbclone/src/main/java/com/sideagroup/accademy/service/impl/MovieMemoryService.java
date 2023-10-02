package com.sideagroup.accademy.service.impl;

import com.sideagroup.accademy.dto.MovieDto;
import com.sideagroup.accademy.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Service
@Service("mainMovieService")
public class MovieMemoryService implements MovieService {
    private List<MovieDto> movies = new ArrayList<>();

    @Override
    public Iterable<MovieDto> getAll() {
        return movies;
    }

    @Override
    public Optional<MovieDto> getById(String id) {
        Optional<MovieDto> opt = movies.stream().filter(item->item.getId().equals(id)).findFirst();
        return opt;
    }

    @Override
    public MovieDto create(MovieDto movie) {
        movies.add(movie);
        return movie;
    }

    @Override
    public Optional<MovieDto> update(String id, MovieDto movie) {
        Optional<MovieDto> opt = movies.stream().filter(item->item.getId().equals(id)).findFirst();

        if (opt.isEmpty())
            return opt;

        MovieDto myMovie = opt.get();
        myMovie.setTitle(movie.getTitle());
        myMovie.setYear(movie.getYear());
        myMovie.setRunningTime(movie.getRunningTime());

        return opt;
    }

    @Override
    public boolean deleteById(String id) {
        Optional<MovieDto> opt = movies.stream().filter(item->item.getId().equals(id)).findFirst();

        if (opt.isEmpty())
            return false;

        movies.remove(opt.get());

        return true;
    }
}
