package com.sideagroup.accademy.mapper;

import com.sideagroup.accademy.dto.CelebrityDto;
import com.sideagroup.accademy.dto.GetAllCelebritiesResponseDto;
import com.sideagroup.accademy.dto.MovieCelebrityDto;
import com.sideagroup.accademy.dto.MovieDto;
import com.sideagroup.accademy.model.Celebrity;
import com.sideagroup.accademy.model.Movie;
import com.sideagroup.accademy.model.MovieCelebrity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CelebrityMapper extends BaseMapper{

    public GetAllCelebritiesResponseDto toDto(Page<Celebrity> entities, int size) {
        GetAllCelebritiesResponseDto dto = new GetAllCelebritiesResponseDto();
        dto.getPagination().setCurrentPage(entities.getNumber());
        dto.getPagination().setTotalElements(entities.getTotalElements());
        dto.getPagination().setTotalPages(entities.getTotalPages());
        dto.getPagination().setPageSize(size);
        dto.getCelebrities().addAll(entities.getContent().stream().map(item -> toDto(item, false)).toList());
        return dto;
    }

    public CelebrityDto toDto(Celebrity entity, boolean withMovie) {
        CelebrityDto dto = new CelebrityDto();
        dto.setBirthYear(entity.getBirthYear());
        dto.setId(entity.getId());
        dto.setName(entity.getPrimaryName());
        dto.setDeathYear(entity.getDeathYear());

        if (!withMovie)
            return dto;

        Set<MovieCelebrity> movieCelebritySet = entity.getTitles();
        for (MovieCelebrity tp : movieCelebritySet) {
            MovieCelebrityDto movieCelebrityDto = new MovieCelebrityDto();
            movieCelebrityDto.setTitle(tp.getMovie().getTitle());
            movieCelebrityDto.setCategory(tp.getCategory());
            movieCelebrityDto.setCharacters(normalizeCharacters(tp.getCharacters()));
            dto.getMovies().add(movieCelebrityDto);
        }

        return dto;
    }

    public Celebrity toEntity(CelebrityDto dto) {
        Celebrity entity = new Celebrity();
        entity.setId(dto.getId());
        entity.setBirthYear(dto.getBirthYear());
        entity.setDeathYear(dto.getDeathYear());
        entity.setPrimaryName(dto.getName());
        return entity;
    }

    public void updateFromDto(Celebrity entity, CelebrityDto dto) {
        entity.setBirthYear(dto.getBirthYear());
        entity.setDeathYear(dto.getDeathYear());
        entity.setPrimaryName(dto.getName());
    }
}
