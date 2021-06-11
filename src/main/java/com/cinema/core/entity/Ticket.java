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

}
