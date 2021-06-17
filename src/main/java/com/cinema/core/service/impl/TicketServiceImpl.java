package com.cinema.core.service.impl;

import com.cinema.core.DAO.DAOException;
import com.cinema.core.entity.Hall;
import com.cinema.core.entity.Session;
import com.cinema.core.entity.Slot;
import com.cinema.core.entity.Ticket;
import com.cinema.core.repository.SessionRepository;
import com.cinema.core.repository.SlotRepository;
import com.cinema.core.repository.TicketRepository;
import com.cinema.core.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private final Logger logger  = LoggerFactory.getLogger(TicketServiceImpl.class);

    private final SessionRepository sessionRepository;
    private final SlotRepository slotRepository;
    private final TicketRepository ticketRepository;

    public TicketServiceImpl(SessionRepository sessionRepository, SlotRepository slotRepository, TicketRepository ticketRepository) {
        this.sessionRepository = sessionRepository;
        this.slotRepository = slotRepository;
        this.ticketRepository = ticketRepository;
    }

    @Transactional
    @Override
    public Boolean buyTicket(Long sessionId, Long slotId){
        try{
            if(sessionId == null || slotId == null){
                throw new DAOException("session or slot id is null");
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
}
