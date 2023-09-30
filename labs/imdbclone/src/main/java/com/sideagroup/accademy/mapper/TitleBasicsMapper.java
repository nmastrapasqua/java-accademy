package com.sideagroup.accademy.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sideagroup.accademy.dto.CastItemDto;
import com.sideagroup.accademy.dto.GetAllMovieResponseDto;
import com.sideagroup.accademy.dto.MovieDto;
import com.sideagroup.accademy.model.TitleBasics;
import com.sideagroup.accademy.model.TitlePrincipals;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
public class TitleBasicsMapper {

    public MovieDto toDto(TitleBasics entity, boolean withCast) {
        MovieDto dto = new MovieDto();
        dto.setTitle(entity.getTitle());
        dto.setId(entity.getId());
        dto.setYear(entity.getYear());
        dto.setRunningTime(entity.getRuntimeMinutes());
        dto.setGenres(entity.getGenres());

        if (!withCast)
            return dto;

        Set<TitlePrincipals> titlePrincipalsSet = entity.getNames();
        for (TitlePrincipals tp : titlePrincipalsSet ) {
            CastItemDto castItemDto = new CastItemDto();
            castItemDto.setName(tp.getNameBasics().getPrimaryName());
            castItemDto.setCategory(tp.getCategory());
            castItemDto.setCharacters(normalizeCharacters(tp.getCharacters()));
            dto.getCast().add(castItemDto);
        }
        return dto;
    }

    public GetAllMovieResponseDto toDto(Page<TitleBasics> movies, int size) {
        GetAllMovieResponseDto dto = new GetAllMovieResponseDto();
        dto.setCurrentPage(movies.getNumber());
        dto.setTotalElements(movies.getTotalElements());
        dto.setTotalPages(movies.getTotalPages());
        dto.setPageSize(size);
        dto.getMovies().addAll(movies.getContent().stream().map(item -> toDto(item, false)).toList());
        return dto;
    }

    public TitleBasics toEntity(MovieDto dto) {
        TitleBasics entity = new TitleBasics();
        entity.setTitle(dto.getTitle());
        entity.setGenres(dto.getGenres());
        entity.setId(dto.getId());
        entity.setYear(dto.getYear());
        entity.setRuntimeMinutes(dto.getRunningTime());
        return entity;
    }

    public void updateFromDto(TitleBasics entity, MovieDto dto) {
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
