package com.cinema.core.DAO;

import com.cinema.core.entity.Hall;
import com.cinema.core.entity.Slot;
import com.cinema.core.repository.SlotRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SlotDao implements ISlotDao{
    private final SlotRepository slotRepository;
    private static final Logger logger = LogManager.getLogger(HallDao.class);

    @Autowired
    public SlotDao(SlotRepository slotRepository) {
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
