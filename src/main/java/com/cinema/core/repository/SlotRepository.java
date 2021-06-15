package com.cinema.core.repository;

import com.cinema.core.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends JpaRepository<Slot,Long> {
    public void deleteAllByHallSlotId(Long hallId);
}
