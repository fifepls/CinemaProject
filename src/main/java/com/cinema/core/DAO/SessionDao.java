package com.cinema.core.DAO;

import com.cinema.core.entity.Film;
import com.cinema.core.entity.Hall;
import com.cinema.core.entity.Session;
import com.cinema.core.repository.FilmRepository;
import com.cinema.core.repository.HallRepository;
import com.cinema.core.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SessionDao {
    private final SessionRepository sessionRepository;
    private final FilmRepository filmRepository;
    private final HallRepository hallRepository;

    @Autowired
    public SessionDao(SessionRepository sessionRepository, FilmRepository filmRepository, HallRepository hallRepository) {
        this.sessionRepository = sessionRepository;
        this.filmRepository = filmRepository;
        this.hallRepository = hallRepository;
    }

    public boolean addSession(Long filmId, BigDecimal ticketPrice, Long hallId, String sessionTime){
        try{
            Optional<Film> filmOptional = filmRepository.findById(filmId);
            Optional<Hall> hallOptional = hallRepository.findById(hallId);
            Film film = null;
            Hall hall = null;

            if(filmOptional.isPresent() && hallOptional.isPresent()){
                film = filmOptional.get();
                hall = hallOptional.get();
            }else {
                return false;
            }

            Session newSession = new Session(ticketPrice,sessionTime,hall,film);

            sessionRepository.save(newSession);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public  boolean removeSessionById(Long id){
        try{
            sessionRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Session> getAllSessionsByFilmId(Long filmId){
        try{
            List<Session> sessions = sessionRepository.findAllByFilmId(filmId);
            if(sessions != null){
                return sessions;
            }else {
                return Collections.emptyList();
            }
        }catch (Exception e){
            return Collections.emptyList();
        }
    }



}
