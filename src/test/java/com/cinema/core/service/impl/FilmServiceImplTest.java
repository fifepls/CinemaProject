package com.cinema.core.service.impl;

import com.cinema.core.repository.FilmRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class FilmServiceImplTest {

    @Autowired
    private FilmServiceImpl filmService;

    @MockBean
    private FilmRepository filmRepository;

    @Test
    void addNewFilm() {
        String title = "title";
        String description = "description";
        Assertions.assertTrue(filmService.addNewFilm(title,description));
    }

    @Test
    void removeFilmById() {
        Assertions.assertTrue(filmService.removeFilmById(1L));
        Mockito.verify(filmRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    void updateFilmById() {


    }
}