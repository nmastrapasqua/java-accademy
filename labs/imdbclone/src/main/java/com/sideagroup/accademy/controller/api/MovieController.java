package com.sideagroup.accademy.controller.api;

import com.sideagroup.accademy.dto.MovieDto;
import com.sideagroup.accademy.service.impl.MovieMemoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    // Per i più esperti, non badate a queste variabili;
    // Il controller evolverà durante il corso.
    private MovieMemoryService movieServices = new MovieMemoryService();
    //private MovieDbService movieServices = new MovieDbService();


    @GetMapping
    public Iterable<MovieDto> getAll() {
        return movieServices.getAll();
    }

    @GetMapping("{id}")
    public MovieDto getById(@PathVariable long id) {
        Optional<MovieDto> opt = movieServices.getById(id);

        if (opt.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");

        return opt.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDto create(@RequestBody MovieDto movie) {
        return movieServices.create(movie);
    }

    @PutMapping("{id}")
    public MovieDto update(@PathVariable long id, @RequestBody MovieDto movie) {
        Optional<MovieDto> opt = movieServices.update(id, movie);

        if (opt.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");

        return opt.get();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long id) {
        movieServices.deleteById(id);
    }
}
