package com.cinema.core.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "halls")
public class HallEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "hall")
    private List<SessionEntity> sessions;

    @OneToMany(mappedBy = "hallSlot")
    private List<SlotEntity> slots;

    public HallEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SessionEntity> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionEntity> sessions) {
        this.sessions = sessions;
    }

    public List<SlotEntity> getSlots() {
        return slots;
    }

    public void setSlots(List<SlotEntity> slots) {
        this.slots = slots;
    }
}
