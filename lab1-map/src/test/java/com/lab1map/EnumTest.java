package com.lab1map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.lab1map.entities.Dia;
import com.lab1map.entities.HoraAula;

//criamos essa classe de teste apenas para testar a enumeração Dia e a HoraAula
class EnumTest {
    
    @Test
    void diaEnum_nomeCorreto() {
        assertEquals("SEGUNDA", Dia.SEGUNDA.name());
    }

    @Test
    void diaEnum_quantidadeCorreta() {
        assertEquals(5, Dia.values().length);
    }

    @Test
    void horaAulaEnum_nomeCorreto() {
        assertEquals("_07_09", HoraAula._07_09.name());
    }

    @Test
    void horaAulaEnum_quantidadeCorreta() {
        assertEquals(5, HoraAula.values().length);
    }
}
