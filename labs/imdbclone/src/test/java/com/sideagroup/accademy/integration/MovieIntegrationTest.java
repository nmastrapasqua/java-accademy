package com.sideagroup.accademy.integration;

import com.sideagroup.accademy.dto.GetAllMoviesResponseDto;
import com.sideagroup.accademy.dto.MovieDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = "h2")
public class MovieIntegrationTest {

    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost";

    private static RestTemplate restTemplate;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void beforeSetup() {
        baseUrl = baseUrl + ":" + port + "/api/v1/movies";
    }

    @Test
    void shouldFetchMoviesTest() {
        int totalExpected = 200;
        GetAllMoviesResponseDto response = restTemplate.getForObject(baseUrl, GetAllMoviesResponseDto.class);
        assertThat(response.getPagination().getTotalElements()).isEqualTo(totalExpected);
    }

    @Test
    void shouldFetchOneMovieByIdTest() {
        String movieId = "tt0150021";
        String expectedTitle = "Camouflage";
        MovieDto existingMovie = restTemplate.getForObject(baseUrl+"/"+movieId, MovieDto.class);

        assertNotNull(existingMovie);
        assertEquals(expectedTitle, existingMovie.getTitle());
    }
}
