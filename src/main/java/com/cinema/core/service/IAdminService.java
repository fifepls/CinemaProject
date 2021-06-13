package com.cinema.core.service;

import com.cinema.core.entity.Film;
import com.cinema.core.entity.Session;

import java.math.BigDecimal;
import java.util.List;

public interface IAdminService {
    public Boolean adminAddNewFilm(String title, String description);
    public Boolean adminRemoveFilmById(Long id);
    public Boolean adminUpdateFilmById(Long filmId, String newTitle, String newDescription);
    public List<Film> adminGetAllFilms();
    public Boolean adminAddSession(Long filmId, BigDecimal ticketPrice, Long HallId, String sessionTime);
    public Boolean adminRemoveSessionById(Long id);
    public List<Session> adminGetAllSessionsByFilmId(Long filmId);
    public Boolean adminAddHall();
    public Boolean adminRemoveHall(Long hallId);
}
