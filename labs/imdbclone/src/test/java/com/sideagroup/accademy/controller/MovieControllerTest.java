package com.sideagroup.accademy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sideagroup.accademy.controller.api.MovieController;
import com.sideagroup.accademy.dto.MovieDto;
import com.sideagroup.accademy.dto.RatingDto;
import com.sideagroup.accademy.exception.GenericServiceException;
import com.sideagroup.accademy.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MovieController.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Autowired
    private ObjectMapper objectMapper;

    private MovieDto starWars;

    @BeforeEach
    void init() {
        starWars = new MovieDto();
        starWars.setTitle("Star Wars: Episode III - Revenge of the Sith");
        starWars.setId("tt0121766");
        starWars.setYear(2005);
        starWars.setGenres("Action,Adventure,Fantasy");
        starWars.setRating(new RatingDto(7.5,742090));
        starWars.setRunningTime(140);
    }

    @Test
    void shouldCreateNewMovie() throws Exception {

        when(movieService.create(any(MovieDto.class))).thenReturn(starWars);

        mockMvc.perform(post("/api/v1/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(starWars)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(starWars.getId())))
                .andExpect(jsonPath("$.title", is(starWars.getTitle())))
                .andExpect(jsonPath("$.year", is(starWars.getYear())));
    }

    @Test
    void shouldNotCreateNewMovie() throws Exception {

        when(movieService.create(any(MovieDto.class))).thenThrow(GenericServiceException.class);

        mockMvc.perform(post("/api/v1/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(starWars)))
                .andExpect(status().isBadRequest());
    }
}
