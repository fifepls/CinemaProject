package com.cinema.core.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SlotTest {

  /*  @Test
    void testEquals() {
        Slot slot1 = new Slot();
        slot1.setId(1L);

        Slot slot2 = new Slot();
        slot1.setId(1L);

        Assertions.assertEquals(slot1,slot2);
    }

    @Test
    void testNotEquals(){
        Slot slot1 = new Slot();
        slot1.setId(1L);

        Slot slot2 = new Slot();
        slot1.setId(2L);

        Assertions.assertNotEquals(slot1,slot2);

    }*/

    @Test
    void testHashCode() {
        Slot slot1 = new Slot();
        slot1.setId(1L);

        Slot slot2 = new Slot();
        slot1.setId(1L);

        Assertions.assertEquals(slot1.hashCode(),slot2.hashCode());

    }

    @Test
    void testDoesntSameHashCode() {
        Slot slot1 = new Slot();
        slot1.setId(1L);

        Slot slot2 = new Slot();
        slot1.setId(2L);

        Assertions.assertNotEquals(slot1.hashCode(),slot2.hashCode());
    }
}