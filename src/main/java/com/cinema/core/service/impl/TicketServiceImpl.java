package com.cinema.core.service.impl;

import com.cinema.core.DAO.DAOException;
import com.cinema.core.DAO.ITicketDao;
import com.cinema.core.service.ITicketService;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements ITicketService {

    private final ITicketDao ticketDao;

    public TicketServiceImpl(ITicketDao ticketDao) {
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
