package com.cinema.core.DAO;

import com.cinema.core.entity.Hall;
import com.cinema.core.entity.Slot;

import java.util.List;

public interface IHallDao {
    public Hall addHall() throws DAOException;
    public Boolean removeHallById(Long id) throws DAOException;
}
