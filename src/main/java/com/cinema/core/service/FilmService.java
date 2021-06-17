package com.cinema.core.service;

import com.cinema.core.entity.Film;
import com.cinema.core.service.exception.FilmNotRemovedException;
import com.cinema.core.service.exception.FilmNotUpdatedException;

import java.util.List;

public interface FilmService {
    public Film addNewFilm(String title, String description) throws FilmNotUpdatedException;
    public Boolean removeFilmById(Long id) throws FilmNotUpdatedException, FilmNotRemovedException;
    public Film updateFilmById(Long filmId, String newTitle, String newDescription) throws FilmNotUpdatedException;
    public List<Film> getAllFilms();
}
