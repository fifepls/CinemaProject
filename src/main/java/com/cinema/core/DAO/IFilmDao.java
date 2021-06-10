package com.cinema.core.DAO;

import com.cinema.core.entity.Film;

import java.util.List;

public interface IFilmDao {
    public Boolean addFilm(String title, String description) throws DAOException;
    public Boolean removeFilmById(Long id) throws DAOException;
    public Boolean updateFilmById(Long id, String newTitle, String newDescription) throws DAOException;
    public List<Film> getListOfFilms() throws DAOException;

}
