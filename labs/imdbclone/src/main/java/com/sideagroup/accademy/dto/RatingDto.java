package com.sideagroup.accademy.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private Double averageRating;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer numVotes;
}
