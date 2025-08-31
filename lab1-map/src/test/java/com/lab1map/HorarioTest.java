package com.lab1map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.lab1map.entities.Dia;
import com.lab1map.entities.HoraAula;
import com.lab1map.entities.Horario;

//criamos essa classe de HorarioTest apenas para garantir que estamos criando um horario com o dia e hora correta
class HorarioTest {

    @Test
    void criarHorario_diaCorreto() {
        Horario horario = new Horario(Dia.QUARTA, HoraAula._11_13);
        assertEquals(Dia.QUARTA, horario.getDia());
    }

    @Test
    void criarHorario_horaCorreta() {
        Horario horario = new Horario(Dia.QUARTA, HoraAula._11_13);
        assertEquals(HoraAula._11_13, horario.getHora());
    }

    @Test
    void toString_formatacaoCorreta() {
        Horario horario = new Horario(Dia.SEXTA, HoraAula._16_18);
        assertEquals("SEXTA - 16:00 - 18:00", horario.toString());
    }
}
