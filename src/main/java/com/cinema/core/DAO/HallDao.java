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

    public Boolean addHall(){
        try {
            Hall newHall = new Hall();
            newHall.setSlots(initSlots(newHall));
            hallRepository.save(newHall);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Boolean removeHallById(Long id){
        try{
            hallRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private List<Slot> initSlots(Hall hall){
        return Stream.of(new Slot(hall),
                new Slot(hall),//1
                new Slot(hall),//2
                new Slot(hall),//3
                new Slot(hall),//4
                new Slot(hall),//5
                new Slot(hall),//6
                new Slot(hall),//7
                new Slot(hall),//8
                new Slot(hall),//9
                new Slot(hall),//10
                new Slot(hall),//11
                new Slot(hall),//12
                new Slot(hall),//13
                new Slot(hall),//14
                new Slot(hall)//15
            ).collect(Collectors.toList());
    }


}
