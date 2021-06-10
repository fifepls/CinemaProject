package com.cinema.core.DAO;

import com.cinema.core.entity.Hall;
import com.cinema.core.entity.Slot;

import java.util.List;

public interface IHallDao {
    public Boolean addHall();
    public Boolean removeHallById(Long id);
}
