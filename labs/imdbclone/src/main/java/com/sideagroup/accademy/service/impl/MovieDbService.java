package com.sideagroup.accademy.service.impl;

import com.sideagroup.accademy.dto.GetAllMoviesResponseDto;
import com.sideagroup.accademy.dto.MovieCelebrityDto;
import com.sideagroup.accademy.dto.MovieDto;
import com.sideagroup.accademy.exception.GenericServiceException;
import com.sideagroup.accademy.mapper.MovieCelebrityMapper;
import com.sideagroup.accademy.mapper.MovieMapper;
import com.sideagroup.accademy.model.Celebrity;
import com.sideagroup.accademy.model.Movie;
import com.sideagroup.accademy.model.MovieCelebrity;
import com.sideagroup.accademy.model.MovieCelebrityKey;
import com.sideagroup.accademy.repository.CelebrityRepository;
import com.sideagroup.accademy.repository.MovieCelebrityRepository;
import com.sideagroup.accademy.repository.MovieRepository;
import com.sideagroup.accademy.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MovieDbService implements MovieService {

    private static final Logger logger = LoggerFactory.getLogger(MovieDbService.class);

    @Autowired
    private MovieRepository repo;

    @Autowired
    private CelebrityRepository celebrityRepo;

    @Autowired
    private MovieCelebrityRepository movieCelebrityRepository;

    @Autowired
    private MovieMapper mapper;

    @Autowired
    private MovieCelebrityMapper movieCelebrityMapper;

    @Override
    public GetAllMoviesResponseDto getAll(int page, int size, String orderBy) {
        validateInput(orderBy);
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        Page<Movie> movies = repo.findAll(pageable);
        return mapper.toDto(movies, size);
    }

    @Override
    public Optional<MovieDto> getById(String id) {
        Optional<Movie> result = repo.findById(id);
        if (!result.isEmpty()) {
            MovieDto dto = mapper.toDto(result.get(), true);
            return Optional.of(dto);
        }

        return Optional.empty();
    }

    @Override
    public MovieDto create(MovieDto movie) {
        Optional<Movie> opt = repo.findById(movie.getId());
        if (!opt.isEmpty())
            throw new GenericServiceException("Movie with id " + movie.getId() + " already exists");
        Movie entity = repo.save(mapper.toEntity(movie));
        return mapper.toDto(entity, false);
    }

    @Override
    public Optional<MovieDto> update(String id, MovieDto movie) {
        Optional<Movie> opt = repo.findById(id);
        if (opt.isEmpty())
            return Optional.empty();

        Movie entity = opt.get();
        mapper.updateFromDto(entity, movie);
        entity = repo.save(entity);

        return Optional.of(mapper.toDto(entity, false));
    }

    @Override
    public MovieCelebrityDto associateCelebrity(String movieId, String celebrityId, MovieCelebrityDto body) {
        Optional<Movie> movie = repo.findById(movieId);
        if (movie.isEmpty())
            throw new GenericServiceException("Movie with id " + movieId + " does not exists");
        Optional<Celebrity> celebrity = celebrityRepo.findById(celebrityId);
        if (celebrity.isEmpty())
            throw new GenericServiceException("Celebrity with id " + celebrityId + " does not exists");

        MovieCelebrityKey key = new MovieCelebrityKey(celebrityId, movieId);
        Optional<MovieCelebrity> rel = movieCelebrityRepository.findById(key);
        if (!rel.isEmpty())
            throw new GenericServiceException("Association between " + movieId + " and " + celebrityId + " already exists");

        MovieCelebrity entity = new MovieCelebrity(key);
        entity.setCelebrity(celebrity.get());
        entity.setMovie(movie.get());
        entity.setCategory(body.getCategory());
        entity.setCharacters(body.getCharacters());
        entity = movieCelebrityRepository.save(entity);
        return movieCelebrityMapper.toDto(entity);
    }

    @Override
    public boolean deleteById(String id) {
        repo.deleteById(id);
        return true;
    }

    private void validateInput(String orderBy) {
        if (!"id".equals(orderBy) &&
            !"title".equals(orderBy) &&
            !"year".equals(orderBy)) {
            throw new GenericServiceException("Invalid Sort field '" + orderBy + "'. Valid values are: [id, title, year]");
        }
    }
}
