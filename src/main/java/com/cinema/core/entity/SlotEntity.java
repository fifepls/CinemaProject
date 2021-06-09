package com.cinema.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "slots")
public class SlotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private HallEntity hallSlot;


    public SlotEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HallEntity getHallSlot() {
        return hallSlot;
    }

    public void setHallSlot(HallEntity hallSlot) {
        this.hallSlot = hallSlot;
    }
}
