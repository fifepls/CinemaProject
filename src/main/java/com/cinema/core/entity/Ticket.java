package com.cinema.core.entity;

import javax.persistence.*;


@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "session_id")
    Session session;

    @OneToOne
    @JoinColumn(name = "slot_id")
    Slot slot;

    public Ticket() {
    }

    public Ticket(Session session, Slot slot) {
        this.session = session;
        this.slot = slot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
