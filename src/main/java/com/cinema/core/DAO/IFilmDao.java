package com.cinema.core.DAO;

import com.cinema.core.entity.Film;

import java.util.List;

public interface IFilmDao {
    public Boolean addFilm(String title, String description);
    public Boolean removeFilmById(Long id);
    public Boolean updateFilmById(Long id, String newTitle, String newDescription);
    public List<Film> getListOfFilms();

}
