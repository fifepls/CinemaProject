package com.cinema.core.service;

import com.cinema.core.entity.Film;
import com.cinema.core.entity.Session;

import java.util.List;

public interface IUserService {
    public List<Film> getListOfFilms();
    public List<Session> getListOfSessionsByFilmId(Long filmId);
    public Boolean buyTicket(Long sessionId, Long slotId);
}
