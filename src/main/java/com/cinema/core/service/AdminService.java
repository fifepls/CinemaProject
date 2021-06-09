package com.cinema.core.service;

import com.cinema.core.entity.Film;
import com.cinema.core.entity.Session;
import com.cinema.core.repository.FilmRepository;
import com.cinema.core.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AdminService {

    private final FilmRepository filmRepository;
    private final SessionRepository sessionRepository;

    @Autowired
        public AdminService(FilmRepository filmRepository, SessionRepository sessionRepository) {
        this.filmRepository = filmRepository;
        this.sessionRepository = sessionRepository;
    }

    public Boolean adminAddFilm(Film film){ //method to add new film into database
       try{
          filmRepository.save(film);//if saved true
          return true;
       }catch (Exception e){//if not saved false
           return false;
       }
    }

    public Boolean adminRemoveFilmById(Long id){ //method to remove film by film id
        try{
            filmRepository.deleteById(id); //if removed true
            return true;
        }catch (Exception e){
            return false; //if not removed false
        }
    }


    public Boolean adminAddSession(Session session){
        try{
            sessionRepository.save(session); //method to add new session for film
            return true;//if added new session true
        }catch (Exception e){
            return false; //if not added new session false
        }
    }

    public List<Session> adminGetAllSessionByFilmId(Long filmId){
        List<Session> filmSessions = sessionRepository.findAllByFilmId(filmId);
        if(filmSessions == null){
            return Collections.emptyList();
        }
        return filmSessions;
    }



}