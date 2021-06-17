package com.cinema.core.entity;

import javax.persistence.*;
import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) && Objects.equals(session, ticket.session) && Objects.equals(slot, ticket.slot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, session, slot);
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
