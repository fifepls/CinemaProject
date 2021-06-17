package com.cinema.core.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Ticket> tickets;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(id, session.id) && Objects.equals(ticketPrice, session.ticketPrice) && Objects.equals(session_time, session.session_time) && Objects.equals(hall, session.hall) && Objects.equals(film, session.film) && Objects.equals(tickets, session.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticketPrice, session_time, hall, film, tickets);
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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
