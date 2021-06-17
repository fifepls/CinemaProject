package com.cinema.core.service;

import com.cinema.core.entity.Session;
import com.cinema.core.service.exception.SessionNotAddedException;
import com.cinema.core.service.exception.SessionNotRemovedException;

import java.math.BigDecimal;
import java.util.List;

public interface SessionService {
    public Session addSession(Long filmId, BigDecimal ticketPrice, Long HallId, String sessionTime) throws SessionNotAddedException;
    public Boolean removeSessionById(Long id) throws SessionNotRemovedException;
    public List<Session> getAllSessionsByFilmId(Long filmId);
}
