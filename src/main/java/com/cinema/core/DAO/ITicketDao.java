package com.cinema.core.DAO;

import com.cinema.core.entity.Session;
import com.cinema.core.entity.Slot;

public interface ITicketDao {
    public Boolean addTicket(Long sessionId, Long slotId) throws DAOException;
}
