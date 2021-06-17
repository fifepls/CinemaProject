package com.cinema.core.service;

import com.cinema.core.entity.Session;

import java.math.BigDecimal;
import java.util.List;

public interface SessionService {
    public Boolean addSession(Long filmId, BigDecimal ticketPrice, Long HallId, String sessionTime);
    public Boolean removeSessionById(Long id);
    public List<Session> getAllSessionsByFilmId(Long filmId);
}
