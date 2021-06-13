package com.cinema.core.DAO.impl;

import com.cinema.core.DAO.DAOException;
import com.cinema.core.DAO.ISessionDao;
import com.cinema.core.entity.Film;
import com.cinema.core.entity.Hall;
import com.cinema.core.entity.Session;
import com.cinema.core.repository.FilmRepository;
import com.cinema.core.repository.HallRepository;
import com.cinema.core.repository.SessionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class SessionDaoImpl implements ISessionDao {
    private final SessionRepository sessionRepository;
    private final FilmRepository filmRepository;
    private final HallRepository hallRepository;
    private static final Logger logger = LoggerFactory.getLogger(SessionDaoImpl.class);

    @Autowired
    public SessionDaoImpl(SessionRepository sessionRepository, FilmRepository filmRepository, HallRepository hallRepository) {
        this.sessionRepository = sessionRepository;
        this.filmRepository = filmRepository;
        this.hallRepository = hallRepository;
    }

    public Boolean addSession(Long filmId, BigDecimal ticketPrice, Long hallId, String sessionTime) throws DAOException {
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
            logger.error("failed to add session", e);
            throw new DAOException("failed add session", e);
        }
    }

    public  Boolean removeSessionById(Long id) throws DAOException {
        try{
            sessionRepository.deleteById(id);
            return true;
        }catch (Exception e){
            logger.error("failed to remove session by id",e);
            throw new DAOException("failed remove session by id", e);
        }
    }

    public List<Session> getAllSessionsByFilmId(Long filmId) throws DAOException {
        try{
            List<Session> sessions = sessionRepository.findAllByFilmId(filmId);
            if(sessions != null){
                return sessions;
            }else {
                return Collections.emptyList();
            }
        }catch (Exception e){
            logger.error("failed to get all sessions by film id",e);
            throw new DAOException("filed to get all sessions by film id");
        }
    }
}
