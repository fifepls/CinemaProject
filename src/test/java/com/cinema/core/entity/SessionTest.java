package com.cinema.core.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SessionTest {

    @Test
    void testEquals() {
        Session session1 = new Session();
        Film film = new Film("title1","desc1");
        session1.setId(1L);
        session1.setFilm(film);

        Session session2 = new Session();
        session2.setId(1L);
        session2.setFilm(film);

        Assertions.assertEquals(session1,session2);
    }

    @Test
    void testNotEquals(){
        Session session1 = new Session();
        session1.setId(1L);

        Session session2 = new Session();
        session2.setId(2L);

        Assertions.assertNotEquals(session1,session2);

    }

    @Test
    void testHashCode() {
        Session session1 = new Session();
        session1.setId(1L);

        Session session2 = new Session();
        session2.setId(1L);

        Assertions.assertEquals(session1.hashCode(),session2.hashCode());
    }
    @Test
    void testDoestSameHashCode() {
        Session session1 = new Session();
        session1.setId(1L);

        Session session2 = new Session();
        session2.setId(2L);

        Assertions.assertNotEquals(session1.hashCode(),session2.hashCode());
    }
}