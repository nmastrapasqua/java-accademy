package com.sideagroup.accademy.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CelebrityDto {
    @Schema(description = "Celebrity Id", example = "nm0089217", requiredMode = Schema.RequiredMode.REQUIRED)
    private String id;
    @Schema(description = "Celebrity full name", example = "Orlando Bloom", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @Schema(description = "Year of birth", example = "1977")
    private Integer birthYear;
    private Integer deathYear;
    @Schema(description = "List of movie for this celebrity")
    private List<MovieCelebrityDto> movies;

    public CelebrityDto() {
        movies = new ArrayList<>();
    }

}
