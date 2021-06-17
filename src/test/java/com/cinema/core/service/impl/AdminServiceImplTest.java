package com.cinema.core.service.impl;

import com.cinema.core.entity.Film;
import com.cinema.core.repository.*;
import com.cinema.core.service.IAdminService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AdminServiceImplTest {
    @Autowired
    private IAdminService adminService;

    @MockBean
    private FilmRepository filmRepository;
    @MockBean
    private HallRepository hallRepository;
    @MockBean
    private TicketRepository ticketRepository;
    @MockBean
    private SlotRepository slotRepository;
    @MockBean
    private SessionRepository sessionRepository;

    @Test
    void adminAddNewFilm() {
        String title = "filmtitle";
        String description = "filmdescription";

        Boolean filmAdded = adminService.adminAddNewFilm(title,description);

        Assertions.assertTrue(filmAdded);
    }

    @Test
    void adminRemoveFilmById() throws Exception {
        Film film = new Film("title1", "desc1");
        Mockito.doReturn(film).when(filmRepository).findById(1L).orElseThrow(Exception::new);

    }

    @Test
    void adminUpdateFilmById() {
    }

    @Test
    void adminGetAllFilms() {
    }

    @Test
    void adminAddSession() {
    }

    @Test
    void adminRemoveSessionById() {
    }

    @Test
    void adminGetAllSessionsByFilmId() {
    }

    @Test
    void adminAddHall() {
    }

    @Test
    void adminRemoveHall() {
    }
}