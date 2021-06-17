package com.cinema.core.service.impl;

import com.cinema.core.DAO.DAOException;
import com.cinema.core.entity.Film;
import com.cinema.core.entity.Hall;
import com.cinema.core.entity.Session;
import com.cinema.core.repository.FilmRepository;
import com.cinema.core.repository.HallRepository;
import com.cinema.core.repository.SessionRepository;
import com.cinema.core.service.SessionService;
import com.cinema.core.service.exception.SessionNotAddedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    private final FilmRepository filmRepository;
    private final HallRepository hallRepository;
    private final SessionRepository sessionRepository;

    private final Logger logger = LoggerFactory.getLogger(SessionServiceImpl.class);

    public SessionServiceImpl(FilmRepository filmRepository,
                              HallRepository hallRepository,
                              SessionRepository sessionRepository) {
        this.filmRepository = filmRepository;
        this.hallRepository = hallRepository;
        this.sessionRepository = sessionRepository;
    }

    @Transactional(rollbackOn = Exception.class)
    public Session addSession(Long filmId, BigDecimal ticketPrice, Long hallId, String sessionTime) throws SessionNotAddedException {
        try{
            if(filmId == null || ticketPrice == null || hallId == null || sessionTime == null){
                logger.error("film id, ticket price, hall id, session time is null");
                throw new SessionNotAddedException("film id, ticket price, hall id, session time is null");
            }

            Film film = filmRepository.findById(filmId).orElseThrow(SessionNotAddedException::new);
            Hall hall = hallRepository.findById(hallId).orElseThrow(SessionNotAddedException::new);

            Session newSession = new Session(ticketPrice,sessionTime,hall,film);
            return sessionRepository.save(newSession);
        } catch (SessionNotAddedException e) {
            logger.error("film not found or hall not found", e);
            throw new SessionNotAddedException("session not added",e);
        }
    }

    @Transactional(rollbackOn = Exception.class)
    public Boolean removeSessionById(Long id){
        try{
            if(id == null){
                logger.error("id is null, session doesnt deleted");
                throw new DAOException("id is null, session doesnt deleted");
            }
            sessionRepository.deleteById(id);
            return true;
        }catch (DAOException e){
            logger.error("session with id not found, session doesnt deleted",e);
            return false;
        }
    }

    @Transactional(rollbackOn = Exception.class)
    public List<Session> getAllSessionsByFilmId(Long filmId){
        try {
            if(filmId == null){
                throw new DAOException("film id is null");
            }
            return sessionRepository.findAllByFilmId(filmId);
        }catch (DAOException e){
            logger.error("film with id not found",e);
            return Collections.emptyList();
        }
    }
}
