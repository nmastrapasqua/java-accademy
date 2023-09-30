package com.sideagroup.accademy.mapper;

import com.sideagroup.accademy.dto.MovieCelebrityDto;
import com.sideagroup.accademy.model.MovieCelebrity;
import org.springframework.stereotype.Component;

@Component
public class MovieCelebrityMapper extends BaseMapper{

    public MovieCelebrityDto toDto(MovieCelebrity entity) {
        MovieCelebrityDto dto = new MovieCelebrityDto();
        dto.setCategory(entity.getCategory());
        dto.setCharacters(normalizeCharacters(entity.getCharacters()));
        dto.setTitle(entity.getMovie().getTitle());
        dto.setName(entity.getCelebrity().getPrimaryName());
        return dto;
    }
}
