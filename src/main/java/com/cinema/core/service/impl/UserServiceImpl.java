/*
package com.cinema.core.service.impl;

import com.cinema.core.DAO.DAOException;
import com.cinema.core.DAO.ITicketDao;
import com.cinema.core.entity.Film;
import com.cinema.core.entity.Session;
import com.cinema.core.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final ITicketDao ticketDao;
    private final IFilmDao filmDao;
    private final ISessionDao sessionDao;

    public UserServiceImpl(ITicketDao ticketDao, IFilmDao filmDao, ISessionDao sessionDao) {
        this.ticketDao = ticketDao;
        this.filmDao = filmDao;
        this.sessionDao = sessionDao;
    }

    @Override
    public Boolean buyTicket(Long sessionId, Long slotId){
        Boolean bought = false;
        try{
            bought = ticketDao.addTicket(sessionId, slotId);
        }catch (DAOException e){
            e.printStackTrace();
        }
        return bought;
    }
    @Override
    public List<Film> getListOfFilms() {
        try {
            return filmDao.getListOfFilms();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public List<Session> getListOfSessionsByFilmId(Long filmId) {
        try {
            return sessionDao.getAllSessionsByFilmId(filmId);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
*/
