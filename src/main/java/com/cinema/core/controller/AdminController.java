package com.cinema.core.controller;

import com.cinema.core.entity.Film;
import com.cinema.core.entity.Session;
import com.cinema.core.service.FilmService;
import com.cinema.core.service.HallService;
import com.cinema.core.service.SessionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final FilmService filmService;
    private final HallService hallService;
    private final SessionService sessionService;


    public AdminController(FilmService filmService, HallService hallService, SessionService sessionService) {
        this.filmService = filmService;
        this.hallService = hallService;
        this.sessionService = sessionService;
    }

    @PreAuthorize("hasAuthority('admin:addFilm')")
    @PostMapping("/add/film")
    public Boolean addFilm(@RequestParam(value = "title")String title,
                          @RequestParam(value = "description") String description){
        return filmService.addNewFilm(title,description);
    }

    @PreAuthorize("hasAuthority('admin:getAllFilms')")
    @GetMapping("/get/films")
    public List<Film> getFilms(){
        return filmService.getAllFilms();
    }


    @PreAuthorize("hasAuthority('admin:remFilm')")
    @DeleteMapping("/rem/film")
    public Boolean removeFilm(@RequestParam(value = "id")Long id){
        return filmService.removeFilmById(id);
    }

    @PreAuthorize("hasAuthority('admin:updateFilm')")
    @PostMapping("/update/film")
    public Boolean updateFilm(@RequestParam(value = "id") Long id,
                             @RequestParam(value = "title")String title,
                             @RequestParam(value = "description")String description){
        return filmService.updateFilmById(id,title,description);
    }


    @PreAuthorize("hasAuthority('admin:addSession')")
    @PostMapping("/add/session")
    public Boolean addSession(@RequestParam(value = "filmId") Long id,
                             @RequestParam(value = "ticketPrice") BigDecimal ticketPrice,
                             @RequestParam(value = "hallId") Long hallId,
                             @RequestParam(value = "sessionTime") String sessionTime){
        return sessionService.addSession(id, ticketPrice, hallId, sessionTime);
    }

    @PreAuthorize("hasAuthority('admin:remSession')")
    @DeleteMapping("/rem/session")
    public Boolean removeSessionById(@RequestParam(value = "sessionId") Long sessionId){
        return sessionService.removeSessionById(sessionId);
    }

    @PreAuthorize("hasAuthority('admin:getAllSessions')")
    @GetMapping("/get/sessions")
    public List<Session> getAllSessionsByFilmId(@RequestParam(value = "filmId") Long filmId){
        return sessionService.getAllSessionsByFilmId(filmId);
    }

    @PreAuthorize("hasAuthority('admin:addHall')")
    @PostMapping("/add/hall")
    public Boolean addHall(){
        return hallService.addHall();
    }

    @PreAuthorize("hasAuthority('admin:remHall')")
    @DeleteMapping("/rem/hall")
    public Boolean removeHall(@RequestParam(value = "id") Long hallId){
        return hallService.removeHall(hallId);
    }





}
