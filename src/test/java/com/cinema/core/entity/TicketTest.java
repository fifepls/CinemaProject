package com.cinema.core.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TicketTest {

    @Test
    void testEquals() {
        Ticket ticket1 = new Ticket();
        ticket1.setId(1L);
        Ticket ticket2 = new Ticket();
        ticket2.setId(1L);
        Assertions.assertEquals(ticket1,ticket2);
    }
    @Test
    void testNotEquals() {
        Ticket ticket1 = new Ticket();
        ticket1.setId(1L);
        Ticket ticket2 = new Ticket();
        ticket2.setId(2L);
        Assertions.assertNotEquals(ticket1,ticket2);
    }

    @Test
    void testHashCode() {
        Ticket ticket1 = new Ticket();
        ticket1.setId(1L);
        Ticket ticket2 = new Ticket();
        ticket2.setId(1L);
        Assertions.assertEquals(ticket1.hashCode(),ticket2.hashCode());
    }

    @Test
    void testDoesntSameHashCode() {
        Ticket ticket1 = new Ticket();
        ticket1.setId(1L);
        Ticket ticket2 = new Ticket();
        ticket2.setId(2L);
        Assertions.assertNotEquals(ticket1.hashCode(),ticket2.hashCode());

    }
}