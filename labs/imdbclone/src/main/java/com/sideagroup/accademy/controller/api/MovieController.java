package com.sideagroup.accademy.controller.api;

import com.sideagroup.accademy.dto.GetAllMoviesResponseDto;
import com.sideagroup.accademy.dto.MovieCelebrityDto;
import com.sideagroup.accademy.dto.MovieDto;
import com.sideagroup.accademy.exception.GenericServiceException;
import com.sideagroup.accademy.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieServices ;


    @GetMapping
    public GetAllMoviesResponseDto getAll(
            @RequestParam(name="page", required=false, defaultValue="0") int page,
            @RequestParam(name="size", required=false, defaultValue="20") int size,
            @RequestParam(name="order_by", required=false, defaultValue="id") String orderBy) {
        try {
            return movieServices.getAll(page, size, orderBy);
        } catch(GenericServiceException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("{id}")
    public MovieDto getById(@PathVariable String id) {
        Optional<MovieDto> opt = movieServices.getById(id);

        if (opt.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");

        return opt.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDto create(@RequestBody MovieDto movie) {
        try {
            return movieServices.create(movie);
        } catch (GenericServiceException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("{id}")
    public MovieDto update(@PathVariable String id, @RequestBody MovieDto movie) {
        Optional<MovieDto> opt = movieServices.update(id, movie);

        if (opt.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");

        return opt.get();
    }

    @PutMapping("{movieId}/celebrities/{celebrityId}")
    public MovieCelebrityDto associateCelebrity(
            @PathVariable String movieId,
            @PathVariable String celebrityId,
            @RequestBody MovieCelebrityDto body) {
        try {
            return movieServices.associateCelebrity(movieId, celebrityId, body);
        } catch (GenericServiceException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("{movieId}/celebrities/{celebrityId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCelebrity(
            @PathVariable String movieId,
            @PathVariable String celebrityId) {

            movieServices.removeCelebrity(movieId, celebrityId);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) {
        movieServices.deleteById(id);
    }

}
