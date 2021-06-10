package com.cinema.core.DAO;

import com.cinema.core.entity.Hall;

public interface ISlotDao {
    public void addHallSlots(Hall hall) throws DAOException;
}
