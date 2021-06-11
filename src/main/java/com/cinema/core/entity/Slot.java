package com.cinema.core.entity;

import javax.persistence.*;
import java.util.List;

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


    @OneToOne(mappedBy = "slot")
    Ticket ticket;

    public Slot() {
    }

    public Slot(Long id, Hall hallSlot, Boolean isFree) {
        this.id = id;
        this.hallSlot = hallSlot;
        this.isFree = isFree;
    }

    public Slot(Hall hallSlot) {
        this.hallSlot = hallSlot;
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
}
