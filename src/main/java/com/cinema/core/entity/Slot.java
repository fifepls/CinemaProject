package com.cinema.core.entity;

import javax.persistence.*;

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


    public Slot() {
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
