package com.cinema.core.DAO;

import com.cinema.core.entity.Hall;
import com.cinema.core.entity.Slot;
import com.cinema.core.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class HallDao implements IHallDao {
    private final HallRepository hallRepository;

    @Autowired
    public HallDao(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    public Hall addHall() throws DAOException {
        try {
            Hall newHall = new Hall();
            newHall.setSlots(initSlots(newHall));
            hallRepository.save(newHall);
            return newHall;
        }catch (Exception e){
            throw new DAOException("failed add new hall", e);
        }
    }

    public Boolean removeHallById(Long id) throws DAOException {
        try{
            hallRepository.deleteById(id);
            return true;
        }catch (Exception e){
            throw  new DAOException("failed to remove hall by id", e);
        }
    }

    private List<Slot> initSlots(Hall hall){
        return Stream.of(new Slot(hall,1),//1
                new Slot(hall,2),//2
                new Slot(hall,3),//3
                new Slot(hall,4),//4
                new Slot(hall,5),//5
                new Slot(hall,6),//6
                new Slot(hall,7),//7
                new Slot(hall,8),//8
                new Slot(hall,9),//9
                new Slot(hall,10),//10
                new Slot(hall,11),//11
                new Slot(hall, 12),//12
                new Slot(hall,13),//13
                new Slot(hall,14),//14
                new Slot(hall,15),//15
                new Slot(hall,16)//16
            ).collect(Collectors.toList());
    }

    /*public List<Slot> getAllHallSlots(Hall hall) throws DAOException {
        try{
            return hall.getSlots()

        }catch (Exception e){
            throw new DAOException("failed to get all slots for hall",e);
        }
    }*/


}
