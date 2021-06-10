package com.cinema.core.controller;

import com.cinema.core.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("/admin")
//дописать преауторайзы для методов
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/add/film")
    public String addFilm(@RequestParam(value = "title")String title,
                          @RequestParam(value = "description") String description){
        adminService.adminAddNewFilm(title,description);
        return "adminFilms";
    }

    @GetMapping("/get/films")
    public String getFilms(){
        adminService.adminGetAllFilms();
        return "adminFilms";
    }

    @DeleteMapping("/rem/film")
    public String removeFilm(@RequestParam(value = "id")Long id){
        adminService.adminRemoveFilmById(id);
        return "adminFilms";
    }

    @PostMapping("/update/film")
    public String updateFilm(@RequestParam(value = "id") Long id,
                             @RequestParam(value = "title")String title,
                             @RequestParam(value = "description")String description){
        adminService.adminUpdateFilmById(id,title,description);
        return "adminFilms";
    }


    @PostMapping("/add/session")
    public String addSession(@RequestParam(value = "filmId") Long id,
                             @RequestParam(value = "ticketPrice") BigDecimal ticketPrice,
                             @RequestParam(value = "hallId") Long hallId,
                             @RequestParam(value = "sessionTime") String sessionTime){
        adminService.adminAddSession(id, ticketPrice, hallId, sessionTime);
        return "sessions";
    }

    @DeleteMapping("/rem/session")
    public String removeSessionById(@RequestParam(value = "sessionId") Long sessionId){
        adminService.adminRemoveSessionById(sessionId);
        return "sessions";
    }

    @GetMapping("/get/sessions")
    public String getAllSessionsByFilmId(@RequestParam(value = "filmId") Long filmId){
        adminService.adminGetAllSessionsByFilmId(filmId);
        return "sessions";
    }

    @PostMapping("/add/hall")
    public String addHall(){
        adminService.adminAddHall();
        return "halls";
    }

    @DeleteMapping("/rem/hall")
    public String removeHall(@RequestParam(value = "hallId") Long id){
        adminService.adminRemoveHall(id);
        return "halls";
    }





}
