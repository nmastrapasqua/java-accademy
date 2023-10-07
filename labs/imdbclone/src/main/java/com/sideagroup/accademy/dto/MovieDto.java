package com.sideagroup.accademy.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MovieDto {
    @Schema(description = "Movie Id", example = "tt0120804", required = true)
    private String id;
    @Schema(description = "Movie title", required = true)
    private String title;
    @Schema(description = "Movie year", required = true)
    private Integer year;
    @Schema(description = "Running time in minutes", example = "178", required = true)
    private Integer runningTime;
    @Schema(description = "Comma separated genres of a movie", example = "Action,Adventure", required = true)
    private String genres;
    @Schema(description = "Movie cast. Not used in POST and PUT", required = false)
    private List<MovieCelebrityDto> cast;
    private RatingDto rating;

    public MovieDto() {
        cast = new ArrayList<>();
    }

}
