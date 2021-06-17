package com.cinema.core.service;

import com.cinema.core.entity.Film;

import java.util.List;

public interface FilmService {
    public Boolean AddNewFilm(String title, String description);
    public Boolean RemoveFilmById(Long id);
    public Boolean UpdateFilmById(Long filmId, String newTitle, String newDescription);
    public List<Film> GetAllFilms();
}
