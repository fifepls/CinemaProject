package com.cinema.core.service.impl;

import com.cinema.core.DAO.DAOException;
import com.cinema.core.entity.Film;
import com.cinema.core.entity.Hall;
import com.cinema.core.entity.Session;
import com.cinema.core.entity.Slot;
import com.cinema.core.repository.*;
import com.cinema.core.service.IAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class AdminServiceImpl implements IAdminService {

    private final FilmRepository filmRepository;
    private final HallRepository hallRepository;
    private final SessionRepository sessionRepository;
    private final SlotRepository slotRepository;
    private final TicketRepository ticketRepository;
    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    public AdminServiceImpl(FilmRepository filmRepository, HallRepository hallRepository,
                            SessionRepository sessionRepository, SlotRepository slotRepository,
                            TicketRepository ticketRepository) {
        this.filmRepository = filmRepository;
        this.hallRepository = hallRepository;
        this.sessionRepository = sessionRepository;
        this.slotRepository = slotRepository;
        this.ticketRepository = ticketRepository;
    }

    @Transactional(rollbackOn = Exception.class)
    public Boolean adminAddNewFilm(String title, String description) {
        try{
            if(title == null || description == null){
                logger.error("title or description is null, film doesnt added");
                throw new DAOException("title or description is null, film doesnt added");
            }

            Film newFilm = new Film(title,description);
            filmRepository.save(newFilm);
            return true;
        }catch (DAOException e){
            logger.error("failed to add new film", e);
            return false;
        }
    }

    @Transactional(rollbackOn = Exception.class)
    public Boolean adminRemoveFilmById(Long id){
        try{
            if(id == null){
                logger.error("id is null, film not removed");
                throw new DAOException("id is null, film not removed");
            }

            Film film = filmRepository.findById(id).orElseThrow(DAOException::new);
            for (Session session : film.getSessions()) {
                ticketRepository.deleteAllBySessionId(session.getId());
            }

            filmRepository.deleteById(id);
            return true;
        }catch (DAOException e){
            logger.error("failed to remove film by id", e);
            return false;
        }
    }

    @Transactional(rollbackOn = Exception.class)
    public Boolean adminUpdateFilmById(Long filmId, String newTitle, String newDescription){
       try{
           if(filmId == null){
               logger.error("film id is empty, film doesnt updated");
               throw new DAOException("film id is empty, film doesnt updated");
           }
           Film filmToUpdate = filmRepository.findById(filmId).orElseThrow(DAOException::new);
           filmToUpdate.setTitle(newTitle);
           filmToUpdate.setDescription(newDescription);
           filmRepository.save(filmToUpdate);
           return true;
       }catch (DAOException e){
           logger.error("film not found by id, film doesnt updated",e);
           return false;
       }
    }

    @Transactional(rollbackOn = Exception.class)
    public List<Film> adminGetAllFilms(){
        try{
            return filmRepository.findAll();
        }catch (Exception e){
            return Collections.emptyList();
        }
    }

    @Transactional(rollbackOn = Exception.class)
    public Boolean adminAddSession(Long filmId, BigDecimal ticketPrice, Long hallId, String sessionTime){
        try{
            if(filmId == null || ticketPrice == null || hallId == null || sessionTime == null){
                logger.error("film id, ticket price, hall id, session time is null");
                throw new DAOException("film id, ticket price, hall id, session time is null");
            }

            Film film = filmRepository.findById(filmId).orElseThrow(DAOException::new);
            Hall hall = hallRepository.findById(hallId).orElseThrow(DAOException::new);

            Session newSession = new Session(ticketPrice,sessionTime,hall,film);
            sessionRepository.save(newSession);

            return true;

        } catch (DAOException e) {
            logger.error("film not found or hall not found", e);
            return false;
        }
    }

    @Transactional(rollbackOn = Exception.class)
    public Boolean adminRemoveSessionById(Long id){
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
    public List<Session> adminGetAllSessionsByFilmId(Long filmId){
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

    @Transactional(rollbackOn = Exception.class)
    public Boolean adminAddHall(){
        try {
            Hall newHall = new Hall();
            newHall.setSlots(Stream.of(new Slot(newHall,1),//1
                    new Slot(newHall,2),//2
                    new Slot(newHall,3),//3
                    new Slot(newHall,4),//4
                    new Slot(newHall,5),//5
                    new Slot(newHall,6),//6
                    new Slot(newHall,7),//7
                    new Slot(newHall,8),//8
                    new Slot(newHall,9),//9
                    new Slot(newHall,10),//10
                    new Slot(newHall,11),//11
                    new Slot(newHall, 12),//12
                    new Slot(newHall,13),//13
                    new Slot(newHall,14),//14
                    new Slot(newHall,15),//15
                    new Slot(newHall,16)//16
            ).collect(Collectors.toList()));

            for (Slot slot : newHall.getSlots()) {
                slotRepository.save(slot);
            }

            hallRepository.save(newHall);
            return true;

        }catch (Exception e){
            logger.error("failed to add new hall",e);
            return false;
        }
    }

    @Transactional(rollbackOn = Exception.class)
    public Boolean adminRemoveHall(Long hallId){
        try{
            if(hallId == null){
                throw new DAOException("hall id is null");
            }
            slotRepository.deleteAllByHallSlotId(hallId);
            hallRepository.deleteById(hallId);
            return true;
        }catch (DAOException e){
            logger.error("hall id is null", e);
            return false;
        }
    }
}
