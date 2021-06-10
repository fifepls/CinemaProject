package com.cinema.core.service;

import com.cinema.core.DAO.*;
import com.cinema.core.entity.Film;
import com.cinema.core.entity.Hall;
import com.cinema.core.entity.Session;
import com.cinema.core.entity.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;


@Service
public class AdminService {
    private final ISessionDao sessionDao;
    private final IHallDao hallDao;
    private final IFilmDao filmDao;
    private final ISlotDao slotDao;

    @Autowired
    public AdminService(ISessionDao sessionDao, IHallDao hallDao, IFilmDao filmDao, ISlotDao slotDao) {
        this.sessionDao = sessionDao;
        this.hallDao = hallDao;
        this.filmDao = filmDao;
        this.slotDao = slotDao;
    }


    public Boolean adminAddNewFilm(String title, String description){
        Boolean added = false;
        try{
         added = filmDao.addFilm(title, description);
        }catch (DAOException e) {
            e.printStackTrace();
        }
        return added;
    }

    public Boolean adminRemoveFilmById(Long id){
        Boolean removed = false;
        try{
            removed = filmDao.removeFilmById(id);
        }catch (DAOException e){
            e.printStackTrace();
        }
        return removed;
    }

    public Boolean adminUpdateFilmById(Long filmId, String newTitle, String newDescription){
        Boolean updated = false;
        try {
            updated = filmDao.updateFilmById(filmId, newTitle, newDescription);
        }catch (DAOException e){
            e.printStackTrace();
        }
        return updated;
    }

    public List<Film> adminGetAllFilms(){
        try{
            return filmDao.getListOfFilms();
        }catch (DAOException e){
            return Collections.emptyList();
        }
    }

    public Boolean adminAddSession(Long filmId, BigDecimal ticketPrice, Long HallId, String sessionTime){
        Boolean added = false;
        try {
            added = sessionDao.addSession(filmId, ticketPrice, HallId, sessionTime);
        }catch (DAOException e){
            e.printStackTrace();
        }
        return added;
    }

    public Boolean adminRemoveSessionById(Long id){
        Boolean removed = false;
        try {
            removed = sessionDao.removeSessionById(id);
        }catch(DAOException e){
            e.printStackTrace();
        }
        return removed;
    }

    public List<Session> adminGetAllSessionsByFilmId(Long filmId){
        try {
            return sessionDao.getAllSessionsByFilmId(filmId);
        }catch (DAOException e ){
            return Collections.emptyList();
        }
    }

    public Boolean adminAddHall(){
        Boolean added = false;
        try {
            Hall hall  = hallDao.addHall();
            slotDao.addHallSlots(hall);
            added = true;
        }catch (DAOException e){
            e.printStackTrace();
        }
        return added;
    }

    public Boolean adminRemoveHall(Long hallId){
        Boolean removed = false;
        try{
            removed = hallDao.removeHallById(hallId);
        }catch (DAOException e){
            e.printStackTrace();
        }
        return removed;
    }
}
