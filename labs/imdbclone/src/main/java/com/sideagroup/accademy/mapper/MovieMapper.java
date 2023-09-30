package com.sideagroup.accademy.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sideagroup.accademy.dto.MovieCelebrityDto;
import com.sideagroup.accademy.dto.GetAllMoviesResponseDto;
import com.sideagroup.accademy.dto.MovieDto;
import com.sideagroup.accademy.model.Movie;
import com.sideagroup.accademy.model.MovieCelebrity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
public class MovieMapper {

    public MovieDto toDto(Movie entity, boolean withCast) {
        MovieDto dto = new MovieDto();
        dto.setTitle(entity.getTitle());
        dto.setId(entity.getId());
        dto.setYear(entity.getYear());
        dto.setRunningTime(entity.getRuntimeMinutes());
        dto.setGenres(entity.getGenres());

        if (!withCast)
            return dto;

        Set<MovieCelebrity> movieCelebritySet = entity.getNames();
        for (MovieCelebrity tp : movieCelebritySet) {
            MovieCelebrityDto movieCelebrityDto = new MovieCelebrityDto();
            movieCelebrityDto.setName(tp.getCelebrity().getPrimaryName());
            movieCelebrityDto.setCategory(tp.getCategory());
            movieCelebrityDto.setCharacters(normalizeCharacters(tp.getCharacters()));
            dto.getCast().add(movieCelebrityDto);
        }
        return dto;
    }

    public GetAllMoviesResponseDto toDto(Page<Movie> movies, int size) {
        GetAllMoviesResponseDto dto = new GetAllMoviesResponseDto();
        dto.setCurrentPage(movies.getNumber());
        dto.setTotalElements(movies.getTotalElements());
        dto.setTotalPages(movies.getTotalPages());
        dto.setPageSize(size);
        dto.getMovies().addAll(movies.getContent().stream().map(item -> toDto(item, false)).toList());
        return dto;
    }

    public Movie toEntity(MovieDto dto) {
        Movie entity = new Movie();
        entity.setTitle(dto.getTitle());
        entity.setGenres(dto.getGenres());
        entity.setId(dto.getId());
        entity.setYear(dto.getYear());
        entity.setRuntimeMinutes(dto.getRunningTime());
        return entity;
    }

    public void updateFromDto(Movie entity, MovieDto dto) {
        entity.setTitle(dto.getTitle());
        entity.setGenres(dto.getGenres());
        entity.setYear(dto.getYear());
        entity.setRuntimeMinutes(dto.getRunningTime());
    }

    private String normalizeCharacters(String characters) {
        if (characters == null)
            return null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<String> characterList =
                Arrays.asList(mapper.readValue(characters, String[].class));
            return characterList.toString()
                    .replace("[", "")
                    .replace("]", "");
        } catch (JsonProcessingException e) {
            return characters;
        }
    }
}
