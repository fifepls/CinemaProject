package com.cinema.core.service.impl;

import com.cinema.core.entity.Film;
import com.cinema.core.repository.FilmRepository;
import com.cinema.core.service.exception.FilmNotRemovedException;
import com.cinema.core.service.exception.FilmNotUpdatedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class FilmServiceImplTest {

    @Autowired
    private FilmServiceImpl filmService;

    @MockBean
    private FilmRepository filmRepository;

    @Test
    void addNewFilm() throws FilmNotUpdatedException {
        String title = "title";
        String description = "description";

        Mockito.doReturn(new Film(title,description)).when(filmRepository).save(Mockito.any(Film.class));

        Film addedFilm = filmService.addNewFilm(title,description);

        Assertions.assertEquals(title,addedFilm.getTitle());
        Assertions.assertEquals(description,addedFilm.getDescription());
    }

    @Test
    void removeFilmById() throws FilmNotRemovedException {
        Assertions.assertTrue(filmService.removeFilmById(1L));
        Mockito.verify(filmRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    void updateFilmById() throws FilmNotUpdatedException {
        Film baseFilm = new Film(1L,"title1","description1");
        Optional<Film> optionalFilm = Optional.of(baseFilm);

        Mockito.doReturn(optionalFilm).when(filmRepository).findById(1L);
        Mockito.doReturn(new Film (1L, "newTitle", "newDescription")).when(filmRepository).save(Mockito.any(Film.class));
        Film updatedFilm = filmService.updateFilmById(1L,"newTitle","newDescription");

        Mockito.verify(filmRepository, Mockito.times(1)).findById(1L);
        Mockito.verify(filmRepository,Mockito.times(1)).save(Mockito.any(Film.class));

        Assertions.assertEquals(updatedFilm,baseFilm);
        Assertions.assertEquals("newTitle",updatedFilm.getTitle());
        Assertions.assertEquals("newDescription",updatedFilm.getDescription());
    }
}