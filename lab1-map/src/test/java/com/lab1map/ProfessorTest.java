package com.lab1map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ProfessorTest {

    @Test
    void testCriacaoProfessor() {
        Professor p = new Professor("Dr. João", "joao@uni.com");
        assertEquals("Dr. João", p.getNome());
        assertEquals("joao@uni.com", p.getEmail());
        assertTrue(p.getDisciplinas().isEmpty());
    }

    @Test
    void testAdicionarDisciplina() {
        Professor p = new Professor("Dr. Ana", "ana@uni.com");
        Disciplina d = new Disciplina("Biologia", new Horario(Dia.SEGUNDA, HoraAula._07_09));

        p.adicionarDisciplina(d);
        assertEquals(1, p.getDisciplinas().size());
        assertEquals(d, p.getDisciplinas().get(0));
    }

    @Test
    void testToString() {
        Professor p = new Professor("Dr. Carlos", "carlos@uni.com");
        assertEquals("Dr. Carlos", p.toString());
    }
}

