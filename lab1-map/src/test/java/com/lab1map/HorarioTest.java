package com.lab1map;

import com.lab1map.entities.Horario;
import com.lab1map.entities.Dia;
import com.lab1map.entities.HoraAula;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

//criamos essa classe de HorarioTest apenas para garantir que estamos criando um horario com o dia e hora correta
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
        assertEquals("SEXTA - 16:00 - 18:00", horarioTest2.toString());
    }
}
