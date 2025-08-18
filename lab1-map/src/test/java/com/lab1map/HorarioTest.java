package com.lab1map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class HorarioTest {

    @Test
    void testCriacaoHorario() {
        Horario h = new Horario(Dia.QUARTA, HoraAula._11_13);
        assertEquals(Dia.QUARTA, h.getDia());
        assertEquals(HoraAula._11_13, h.getHora());
    }

    @Test
    void testToString() {
        Horario h = new Horario(Dia.SEXTA, HoraAula._15_17);
        assertEquals("SEXTA - _15_17", h.toString());
    }
}

