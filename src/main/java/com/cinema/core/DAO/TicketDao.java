package com.cinema.core.DAO;

import com.cinema.core.entity.Hall;
import com.cinema.core.entity.Session;
import com.cinema.core.entity.Slot;
import com.cinema.core.entity.Ticket;
import com.cinema.core.repository.SessionRepository;
import com.cinema.core.repository.SlotRepository;
import com.cinema.core.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class TicketDao implements ITicketDao{

    private final TicketRepository ticketRepository;
    private final SessionRepository sessionRepository;
    private final SlotRepository slotRepository;

    @Autowired
    public TicketDao(TicketRepository ticketRepository, SessionRepository sessionRepository,
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
                throw new DAOException("slot with id " +slotId + " not in this hall");
            }

            slot.setFree(false);
            Ticket ticket = new Ticket();
            ticket.setSession(session);
            ticket.setSlot(slot);
            slotRepository.save(slot);
            ticketRepository.save(ticket);
        }catch (Exception e){
            throw new DAOException("failed add ticket " ,e);
        }
        return true;
    }
}
