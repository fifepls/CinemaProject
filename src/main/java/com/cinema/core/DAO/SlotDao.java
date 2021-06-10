package com.cinema.core.DAO;

import com.cinema.core.entity.Hall;
import com.cinema.core.entity.Slot;
import com.cinema.core.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SlotDao implements ISlotDao{

    private final SlotRepository slotRepository;

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
            throw new DAOException("failed add slots for hall");
        }
    }
}
