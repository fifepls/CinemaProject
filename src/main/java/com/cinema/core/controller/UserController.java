/*
package com.cinema.core.controller;

import com.cinema.core.entity.Film;
import com.cinema.core.entity.Session;
import com.cinema.core.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/ticket/buy")
    public Boolean buyTicket(@RequestParam(value = "sessionId") Long sessionId,
                             @RequestParam(value = "slotId") Long slotId){
        return userService.buyTicket(sessionId, slotId);
    }

    @GetMapping("/get/films")
    public List<Film> getAllFilms(){
        return userService.getListOfFilms();
    }

    @GetMapping("/get/sessions")
    public List<Session> getAllSessionByFilmId(@RequestParam(value = "filmId") Long filmId){
        return userService.getListOfSessionsByFilmId(filmId);
    }


}
*/
