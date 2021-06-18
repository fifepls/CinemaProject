package com.cinema.core.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmTest {

    @Test
    void testEquals() {
        Film film = new Film();
        film.setTitle("title1");
        film.setDescription("desc1");

        Film film2 = new Film();
        film2.setTitle("title1");
        film2.setDescription("desc1");
        Assertions.assertEquals(film,film2);
    }

    @Test
    void testNotEquals() {
        Film film = new Film();
        film.setTitle("title1");
        film.setDescription("desc1");

        Film film2 = new Film();
        film2.setTitle("title2");
        film2.setDescription("desc2");
        Assertions.assertNotEquals(film,film2);
    }

    @Test
    void testSameHashCode() {
        Film film1 = new Film();
        film1.setTitle("title");

        Film film2 = new Film();
        film2.setTitle("title");

        Assertions.assertEquals(film1.hashCode(),film2.hashCode());
    }

    @Test
    void testDoesntSameHashCode() {
        Film film1 = new Film();
        film1.setTitle("title1");

        Film film2 = new Film();
        film2.setTitle("title2");

        Assertions.assertNotEquals(film1.hashCode(),film2.hashCode());
    }


}