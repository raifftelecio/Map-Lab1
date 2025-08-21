package com.lab1map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class HorarioTest {

    @Test
    void testCriacaoHorario() {
        Horario horarioTest = new Horario(Dia.QUARTA, HoraAula._11_13);
        assertEquals(Dia.QUARTA, horarioTest.getDia());
        assertEquals(HoraAula._11_13, horarioTest.getHora());
    }

    @Test
    void testToString() {
        Horario horarioTest2 = new Horario(Dia.SEXTA, HoraAula._16_18);
        assertEquals("SEXTA - _16_18", horarioTest2.toString());
    }
}

