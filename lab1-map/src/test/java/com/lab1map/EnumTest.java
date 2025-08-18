package com.lab1map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class EnumTest {

    @Test
    void testDiasEnum() {
        assertEquals("SEGUNDA", Dia.SEGUNDA.name());
        assertEquals(5, Dia.values().length);
    }

    @Test
    void testHoraAulaEnum() {
        assertEquals("_07_09", HoraAula._07_09.name());
        assertEquals(5, HoraAula.values().length);
    }
}
