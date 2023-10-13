package com.sideagroup.accademy.repository;

import com.sideagroup.accademy.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles(value = "h2")
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository repo;

    @Test
    void shouldFetchMoviesByTitleTest() {

        Page<Movie> result =
                repo.findByTitle("%star%", PageRequest.of(0, 30, Sort.by("id")));
        assertThat(result.getContent().size()).isEqualTo(4);
    }
}
