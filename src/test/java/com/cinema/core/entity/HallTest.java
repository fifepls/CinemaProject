package com.cinema.core.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HallTest {

    @Test
    void testEquals() {
        Hall hall = new Hall();
        hall.setId(1L);

        Hall hall2 = new Hall();
        hall2.setId(1L);

        Assertions.assertEquals(hall,hall2);
    }

    @Test
    void testNotEquals() {
        Hall hall = new Hall();
        hall.setId(1L);

        Hall hall2 = new Hall();
        hall2.setId(2L);

        Assertions.assertNotEquals(hall,hall2);
    }
    @Test
    void testHashCode() {
        Hall hall = new Hall();
        hall.setId(1L);

        Hall hall2 = new Hall();
        hall2.setId(1L);

        Assertions.assertEquals(hall.hashCode(),hall2.hashCode());
    }
    @Test
    void testDoesntSameHashCode() {
        Hall hall = new Hall();
        hall.setId(1L);

        Hall hall2 = new Hall();
        hall2.setId(2L);

        Assertions.assertNotEquals(hall.hashCode(),hall2.hashCode());
    }


}