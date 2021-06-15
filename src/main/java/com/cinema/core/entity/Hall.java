package com.cinema.core.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "halls")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "hall",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Session> sessions;

    @OneToMany(mappedBy = "hallSlot",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Slot> slots;

    public Hall() {
    }

    public Hall(Long id, List<Session> sessions, List<Slot> slots) {
        this.id = id;
        this.sessions = sessions;
        this.slots = slots;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

}
