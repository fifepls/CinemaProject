package com.cinema.core.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ticket_price", nullable = false)
    private BigDecimal ticketPrice;

    @Column(name = "session_time", nullable = false)
    private String session_time;


    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;


    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    public Session() {
    }

    public Session(Long id, BigDecimal ticketPrice, String session_time, Hall hall, Film film) {
        this.id = id;
        this.ticketPrice = ticketPrice;
        this.session_time = session_time;
        this.hall = hall;
        this.film = film;
    }

    public Session(BigDecimal ticketPrice, String session_time, Hall hall, Film film) {
        this.ticketPrice = ticketPrice;
        this.session_time = session_time;
        this.hall = hall;
        this.film = film;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getSession_time() {
        return session_time;
    }

    public void setSession_time(String session_time) {
        this.session_time = session_time;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

}
