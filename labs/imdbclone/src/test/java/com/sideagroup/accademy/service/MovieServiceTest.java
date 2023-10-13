package com.sideagroup.accademy.service;

import com.sideagroup.accademy.dto.GetAllMoviesResponseDto;
import com.sideagroup.accademy.dto.MovieDto;
import com.sideagroup.accademy.dto.PaginationDto;
import com.sideagroup.accademy.mapper.MovieMapper;
import com.sideagroup.accademy.model.Movie;
import com.sideagroup.accademy.repository.MovieRepository;
import com.sideagroup.accademy.service.impl.MovieDbService;
import com.sideagroup.accademy.validator.MovieValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;
    @Mock
    private MovieValidator movieValidator;
    @Mock
    private MovieMapper mapper;
    @InjectMocks
    private MovieDbService movieService;

    private Page<Movie> pagedResponse;

    private GetAllMoviesResponseDto getAllMoviesResponseDto;

    private int pageSize;

    @BeforeEach
    void init() {
        Movie m1 = new Movie();
        m1.setId("tt0036177");
        m1.setTitle("Muhomatsu no issho");

        Movie m2 = new Movie();
        m2.setId("tt0114447");
        m2.setTitle("The Silent Force");

        pagedResponse = new PageImpl(Arrays.asList(m1, m2));

        getAllMoviesResponseDto = new GetAllMoviesResponseDto();
        MovieDto md1 = new MovieDto();
        md1.setId("tt0036177");
        md1.setTitle("Muhomatsu no issho");
        MovieDto md2 = new MovieDto();
        md2.setId("tt0114447");
        md2.setTitle("The Silent Force");
        getAllMoviesResponseDto.setMovies(Arrays.asList(md1,md2));
        PaginationDto paginationDto = new PaginationDto();
        paginationDto.setCurrentPage(0);
        paginationDto.setTotalPages(1);
        paginationDto.setTotalElements(getAllMoviesResponseDto.getMovies().size());
        paginationDto.setPageSize(pageSize);
        getAllMoviesResponseDto.setPagination(paginationDto);

        pageSize = 30;
    }

    @Test
    void shouldFetchMoviesTest() {

        when(movieRepository.findAll(any(Pageable.class))).thenReturn(pagedResponse);

        when(mapper.toDto(pagedResponse, pageSize)).thenReturn(getAllMoviesResponseDto);

        GetAllMoviesResponseDto result = movieService.getAll(0, pageSize, "id", null);
        assertThat(result.getPagination().getTotalElements()).isEqualTo(2);
        assertThat(result.getMovies().size()).isEqualTo(2);
    }
}
