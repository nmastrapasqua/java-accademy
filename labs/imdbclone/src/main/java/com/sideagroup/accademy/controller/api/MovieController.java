package com.sideagroup.accademy.controller.api;

import com.sideagroup.accademy.dto.MovieDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    // Per i più esperti, non badate a queste variabili;
    // Il controller evolverà durante il corso.
    private List<MovieDto> movies = new ArrayList<>();
    private long lasdtId = 0;

    @GetMapping
    public Iterable<MovieDto> getAll() {
        return movies;
    }

    @GetMapping("{id}")
    public MovieDto getById(@PathVariable long id) {
        Optional<MovieDto> opt = movies.stream().filter(item->item.getId() == id).findFirst();

        if (opt.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");

        return opt.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDto create(@RequestBody MovieDto movie) {
        lasdtId++;
        movie.setId(lasdtId);
        movies.add(movie);
        return movie;
    }

    @PutMapping("{id}")
    public MovieDto update(@PathVariable long id, @RequestBody MovieDto movie) {
        Optional<MovieDto> opt = movies.stream().filter(item->item.getId() == id).findFirst();

        if (opt.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");

        MovieDto myMovie = opt.get();
        myMovie.setTitle(movie.getTitle());
        myMovie.setYear(movie.getYear());
        myMovie.setRunningTime(movie.getRunningTime());

        return myMovie;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long id) {
        Optional<MovieDto> opt = movies.stream().filter(item->item.getId() == id).findFirst();

        if (!opt.isEmpty())
            movies.remove(opt.get());
    }
}
