package com.cinema.core.DAO.impl;

import com.cinema.core.DAO.DAOException;
import com.cinema.core.DAO.ITicketDao;
import com.cinema.core.entity.Hall;
import com.cinema.core.entity.Session;
import com.cinema.core.entity.Slot;
import com.cinema.core.entity.Ticket;
import com.cinema.core.repository.SessionRepository;
import com.cinema.core.repository.SlotRepository;
import com.cinema.core.repository.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class TicketDaoImpl implements ITicketDao {
    private static final Logger logger = LoggerFactory.getLogger(TicketDaoImpl.class);
    private final TicketRepository ticketRepository;
    private final SessionRepository sessionRepository;
    private final SlotRepository slotRepository;

    @Autowired
    public TicketDaoImpl(TicketRepository ticketRepository, SessionRepository sessionRepository,
                         SlotRepository slotRepository) {
        this.ticketRepository = ticketRepository;
        this.sessionRepository = sessionRepository;
        this.slotRepository = slotRepository;
    }

    @Override
    public Boolean addTicket(Long sessionId, Long slotId) throws DAOException {
        try{
            Session session = sessionRepository.getById(sessionId);
            Slot slot = slotRepository.getById(slotId);
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
        }catch (Exception e){
            logger.error("failed to add ticket", e);
            throw new DAOException("failed add ticket " ,e);
        }
        return true;
    }
}
