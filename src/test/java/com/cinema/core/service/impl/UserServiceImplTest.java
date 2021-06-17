package com.cinema.core.service.impl;

import com.cinema.core.entity.*;
import com.cinema.core.repository.*;
import com.cinema.core.service.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private IUserService userService;

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
    void getListOfFilms() {
        List<Film> list = Stream.of(new Film("title1","dest1"),
                new Film("title2","dest2"))
                .collect(Collectors.toList());
        Mockito.doReturn(list).when(filmRepository).findAll();

        List<Film> listFromService = userService.getListOfFilms();
        Assertions.assertEquals(list,listFromService);
    }

    @Test
    void buyTicket() {
    }


    @Test
    void getListOfSessionsByFilmId() {
    }
}