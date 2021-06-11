package com.cinema.core.service;

import com.cinema.core.DAO.DAOException;
import com.cinema.core.DAO.ITicketDao;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final ITicketDao ticketDao;

    public TicketService(ITicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public Boolean buyTicket(Long sessionId, Long slotId){
        Boolean bought = false;
        try{
            bought = ticketDao.addTicket(sessionId, slotId);
        }catch (DAOException e){
            e.printStackTrace();
        }
        return bought;
    }
}
