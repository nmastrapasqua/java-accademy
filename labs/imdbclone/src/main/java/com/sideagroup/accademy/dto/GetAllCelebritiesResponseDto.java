package com.sideagroup.accademy.dto;

import java.util.ArrayList;
import java.util.List;

public class GetAllCelebritiesResponseDto {
    private PaginationDto pagination = new PaginationDto();
    private List<CelebrityDto> celebrities = new ArrayList<>();

    public PaginationDto getPagination() {
        return pagination;
    }

    public void setPagination(PaginationDto pagination) {
        this.pagination = pagination;
    }

    public List<CelebrityDto> getCelebrities() {
        return celebrities;
    }

    public void setCelebrities(List<CelebrityDto> celebrities) {
        this.celebrities = celebrities;
    }
}
