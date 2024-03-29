package com.cinema.core.repository;

import com.cinema.core.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    public void deleteBySlotId(Long slotId);
    public void deleteAllBySessionId(Long sessionId);
}
