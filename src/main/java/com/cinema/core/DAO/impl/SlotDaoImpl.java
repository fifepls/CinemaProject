package com.cinema.core.DAO.impl;

import com.cinema.core.DAO.DAOException;
import com.cinema.core.DAO.ISlotDao;
import com.cinema.core.entity.Hall;
import com.cinema.core.entity.Slot;
import com.cinema.core.repository.SlotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SlotDaoImpl implements ISlotDao {
    private final SlotRepository slotRepository;
    private static final Logger logger = LoggerFactory.getLogger(SlotDaoImpl.class);

    @Autowired
    public SlotDaoImpl(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    @Override
    public void addHallSlots(Hall hall) throws DAOException {
        try {
            for (Slot slot : hall.getSlots()) {
                slotRepository.save(slot);
            }
        }catch (Exception e){
            logger.error("failed to add slots to hall");
            throw new DAOException("failed add slots for hall");
        }
    }
}
