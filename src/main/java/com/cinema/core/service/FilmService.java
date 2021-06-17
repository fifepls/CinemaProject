package com.cinema.core.service;

import com.cinema.core.entity.Film;

import java.util.List;

public interface FilmService {
    public Boolean addNewFilm(String title, String description);
    public Boolean removeFilmById(Long id);
    public Boolean updateFilmById(Long filmId, String newTitle, String newDescription);
    public List<Film> getAllFilms();
}
