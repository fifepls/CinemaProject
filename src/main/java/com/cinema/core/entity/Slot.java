package com.cinema.core.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "slots")
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hallSlot;

    @Column(name = "is_free")
    private Boolean isFree = true;

    @Column(name = "position")
    private Integer slotPosition;



    @OneToOne(mappedBy = "slot",cascade = CascadeType.ALL, orphanRemoval = true)
    Ticket ticket;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slot slot = (Slot) o;
        return Objects.equals(id, slot.id) && Objects.equals(hallSlot, slot.hallSlot) && Objects.equals(isFree, slot.isFree) && Objects.equals(slotPosition, slot.slotPosition) && Objects.equals(ticket, slot.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hallSlot, isFree, slotPosition, ticket);
    }

    public Slot() {
    }

    public Slot(Long id, Hall hallSlot, Boolean isFree) {
        this.id = id;
        this.hallSlot = hallSlot;
        this.isFree = isFree;
    }

    public Slot(Hall hallSlot,Integer slotPosition) {
        this.hallSlot = hallSlot;
        this.slotPosition = slotPosition;
    }

    public Boolean getFree() {
        return isFree;
    }

    public void setFree(Boolean free) {
        isFree = free;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hall getHallSlot() {
        return hallSlot;
    }

    public void setHallSlot(Hall hallSlot) {
        this.hallSlot = hallSlot;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
