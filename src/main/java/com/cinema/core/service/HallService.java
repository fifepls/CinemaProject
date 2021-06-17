package com.cinema.core.service;

import com.cinema.core.entity.Hall;
import com.cinema.core.service.exception.HallNotAddedException;
import com.cinema.core.service.exception.HallNotRemovedException;

public interface HallService {
    public Hall addHall() throws HallNotAddedException;
    public Boolean removeHall(Long hallId) throws HallNotRemovedException;
}
