package com.sideagroup.accademy.mapper;

import com.sideagroup.accademy.dto.RatingDto;
import com.sideagroup.accademy.model.Rating;
import org.springframework.stereotype.Component;

@Component
public class RatingMapper {
    public RatingDto toDto(Rating entity) {
        RatingDto dto = new RatingDto();
        dto.setAverageRating(entity.getAverageRating());
        dto.setNumVotes(entity.getNumVotes());
        return dto;
    }
}
