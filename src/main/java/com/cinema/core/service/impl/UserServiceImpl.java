package com.cinema.core.service.impl;

import com.cinema.core.DAO.DAOException;
import com.cinema.core.entity.*;
import com.cinema.core.repository.FilmRepository;
import com.cinema.core.repository.SessionRepository;
import com.cinema.core.repository.SlotRepository;
import com.cinema.core.repository.TicketRepository;
import com.cinema.core.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final TicketRepository ticketRepository;
    private final FilmRepository filmRepository;
    private final SessionRepository sessionRepository;
    private final SlotRepository slotRepository;

    @Autowired
    public UserServiceImpl(TicketRepository ticketRepository, FilmRepository filmRepository,
                           SessionRepository sessionRepository, SlotRepository slotRepository) {
        this.ticketRepository = ticketRepository;
        this.filmRepository = filmRepository;
        this.sessionRepository = sessionRepository;
        this.slotRepository = slotRepository;
    }

    @Override
    public Boolean buyTicket(Long sessionId, Long slotId){
        try{
            if(sessionId == null || slotId == null){
                throw new Exception("session or slot id is null");
            }
            Session session = sessionRepository.findById(sessionId).orElseThrow(Exception::new);
            Slot slot = slotRepository.findById(slotId).orElseThrow(Exception::new);
            Hall hall = session.getHall();
            List<Slot> slots = hall.getSlots();

            if(!slots.contains(slot)){
                try{
                    throw new DAOException("this slot not in this hall error");
                }catch (Exception e){
                    logger.error("this slot not in this hall error", e);
                    throw new DAOException("slot with id " +slotId + " not in this hall");
                }
            }

            slot.setFree(false);
            Ticket ticket = new Ticket();
            ticket.setSession(session);
            ticket.setSlot(slot);
            slotRepository.save(slot);
            ticketRepository.save(ticket);
            return true;
        }catch (Exception e) {
            logger.error("failed to buy ticket", e);
            return false;
        }
    }
    @Override
    public List<Film> getListOfFilms() {
        try {
            return filmRepository.findAll();
        } catch (Exception e) {
            logger.error("failed to get list of films");
            return Collections.emptyList();
        }
    }

    @Override
    public List<Session> getListOfSessionsByFilmId(Long filmId) {
        try {
            if(filmId == null){
                throw new DAOException();
            }
            return sessionRepository.findAllByFilmId(filmId);
        } catch (DAOException e){
            logger.error("failed to find sessions by film id", e);
            return Collections.emptyList();
        }
    }
}

