package com.cinema.core.service;

import com.cinema.core.DAO.IFilmDao;
import com.cinema.core.DAO.IHallDao;
import com.cinema.core.DAO.ISessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {
    private final ISessionDao sessionDao;
    private final IHallDao hallDao;
    private final IFilmDao filmDao;

    @Autowired
    public AdminService(ISessionDao sessionDao, IHallDao hallDao, IFilmDao filmDao) {
        this.sessionDao = sessionDao;
        this.hallDao = hallDao;
        this.filmDao = filmDao;
    }


    public Boolean adminAddNewFilm(String title, String description){
        try{
            filmDao.addFilm(title, description);
        }catch (Exception e)

    }

}
