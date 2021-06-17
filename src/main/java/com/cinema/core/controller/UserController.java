package com.cinema.core.controller;

import com.cinema.core.entity.Film;
import com.cinema.core.entity.Session;
import com.cinema.core.service.FilmService;
import com.cinema.core.service.SessionService;
import com.cinema.core.service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final FilmService filmService;
    private final SessionService sessionService;
    private final TicketService ticketService;


    public UserController(FilmService filmService,
                          SessionService sessionService,
                          TicketService ticketService) {
        this.filmService = filmService;
        this.sessionService = sessionService;
        this.ticketService = ticketService;
    }

    @RequestMapping("/ticket/buy")
    public Boolean buyTicket(@RequestParam(value = "sessionId") Long sessionId,
                             @RequestParam(value = "slotId") Long slotId){
        return ticketService.buyTicket(sessionId, slotId);
    }

    @GetMapping("/get/films")
    public List<Film> getAllFilms(){
        return filmService.getAllFilms();
    }

    @GetMapping("/get/sessions")
    public List<Session> getAllSessionByFilmId(@RequestParam(value = "filmId") Long filmId){
        return sessionService.getAllSessionsByFilmId(filmId);
    }


}

