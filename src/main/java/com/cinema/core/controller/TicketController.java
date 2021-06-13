package com.cinema.core.controller;

import com.cinema.core.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final IUserService userService;

    public TicketController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/buy")
    public Boolean buyTicket(@RequestParam(value = "sessionId") Long sessionId,
                             @RequestParam(value = "slotId") Long slotId){
        return userService.buyTicket(sessionId, slotId);
    }

}
