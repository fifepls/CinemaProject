package com.cinema.core.service.impl;

import com.cinema.core.DAO.DAOException;
import com.cinema.core.entity.Hall;
import com.cinema.core.entity.Slot;
import com.cinema.core.repository.HallRepository;
import com.cinema.core.repository.SlotRepository;
import com.cinema.core.service.HallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class HallServiceImpl implements HallService {
    private final Logger logger = LoggerFactory.getLogger(HallServiceImpl.class);
    private final SlotRepository slotRepository;
    private final HallRepository hallRepository;

    public HallServiceImpl(SlotRepository slotRepository, HallRepository hallRepository) {
        this.slotRepository = slotRepository;
        this.hallRepository = hallRepository;
    }

    @Transactional(rollbackOn = Exception.class)
    public Boolean addHall(){
        try {
            Hall newHall = new Hall();
            newHall.setSlots(Stream.of(new Slot(newHall,1),//1
                    new Slot(newHall,2),//2
                    new Slot(newHall,3),//3
                    new Slot(newHall,4),//4
                    new Slot(newHall,5),//5
                    new Slot(newHall,6),//6
                    new Slot(newHall,7),//7
                    new Slot(newHall,8),//8
                    new Slot(newHall,9),//9
                    new Slot(newHall,10),//10
                    new Slot(newHall,11),//11
                    new Slot(newHall, 12),//12
                    new Slot(newHall,13),//13
                    new Slot(newHall,14),//14
                    new Slot(newHall,15),//15
                    new Slot(newHall,16)//16
            ).collect(Collectors.toList()));

            for (Slot slot : newHall.getSlots()) {
                slotRepository.save(slot);
            }

            hallRepository.save(newHall);
            return true;

        }catch (Exception e){
            logger.error("failed to add new hall",e);
            return false;
        }
    }

    @Transactional(rollbackOn = Exception.class)
    public Boolean removeHall(Long hallId){
        try{
            if(hallId == null){
                throw new DAOException("hall id is null");
            }
            slotRepository.deleteAllByHallSlotId(hallId);
            hallRepository.deleteById(hallId);
            return true;
        }catch (DAOException e){
            logger.error("hall id is null", e);
            return false;
        }
    }
}
