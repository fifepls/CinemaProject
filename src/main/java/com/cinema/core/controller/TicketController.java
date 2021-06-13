package com.cinema.core.controller;

import com.cinema.core.service.ITicketService;
import com.cinema.core.service.impl.TicketServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final ITicketService ticketService;

    public TicketController(TicketServiceImpl ticketService) {
        this.ticketService = ticketService;
    }

    @RequestMapping("/buy")
    public Boolean buyTicket(@RequestParam(value = "sessionId") Long sessionId,
                             @RequestParam(value = "slotId") Long slotId){
        return ticketService.buyTicket(sessionId, slotId);
    }

}
