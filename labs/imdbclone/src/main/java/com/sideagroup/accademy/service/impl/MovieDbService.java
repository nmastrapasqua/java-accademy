package com.sideagroup.accademy.service.impl;

import com.sideagroup.accademy.dto.GetAllMovieResponseDto;
import com.sideagroup.accademy.dto.MovieDto;
import com.sideagroup.accademy.exception.GenericServiceException;
import com.sideagroup.accademy.mapper.TitleBasicsMapper;
import com.sideagroup.accademy.model.TitleBasics;
import com.sideagroup.accademy.repository.TitleBasicsRepository;
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
    private TitleBasicsRepository repo;

    @Autowired
    private TitleBasicsMapper mapper;

    @Override
    public GetAllMovieResponseDto getAll(int page, int size, String orderBy) {
        validateInput(orderBy);
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        Page<TitleBasics> movies = repo.findAll(pageable);
        return mapper.toDto(movies, size);
    }

    @Override
    public Optional<MovieDto> getById(String id) {
        Optional<TitleBasics> result = repo.findById(id);
        if (!result.isEmpty()) {
            MovieDto dto = mapper.toDto(result.get(), true);
            return Optional.of(dto);
        }

        return Optional.empty();
    }

    @Override
    public MovieDto create(MovieDto movie) {
        Optional<TitleBasics> opt = repo.findById(movie.getId());
        if (!opt.isEmpty())
            throw new GenericServiceException("Movie with id " + movie.getId() + " already exists");
        TitleBasics entity = repo.save(mapper.toEntity(movie));
        return mapper.toDto(entity, false);
    }

    @Override
    public Optional<MovieDto> update(String id, MovieDto movie) {
        Optional<TitleBasics> opt = repo.findById(id);
        if (opt.isEmpty())
            return Optional.empty();

        TitleBasics entity = opt.get();
        mapper.updateFromDto(entity, movie);
        entity = repo.save(entity);

        return Optional.of(mapper.toDto(entity, false));
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
