package com.lab1map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class DisciplinaTest {

    @Test
    void testCriacaoDisciplinaComProfessor() {
        Professor p = new Professor("Dr. Silva", "silva@uni.com");
        Horario h = new Horario(Dia.TERCA, HoraAula._09_11);
        Disciplina d = new Disciplina("Matemática", p, h);

        assertEquals("Matemática", d.getNome());
        assertEquals(p, d.getProfessor());
        assertEquals(h, d.getHorario());
        assertTrue(d.getAlunos().isEmpty());
    }

    @Test
    void testCriacaoDisciplinaSemProfessor() {
        Horario h = new Horario(Dia.QUARTA, HoraAula._11_13);
        Disciplina d = new Disciplina("Física", h);

        assertEquals("Física", d.getNome());
        assertNull(d.getProfessor());
    }

    @Test
    void testAdicionarAluno() {
        Disciplina d = new Disciplina("Química", new Horario(Dia.QUINTA, HoraAula._13_15));
        Aluno a = new Aluno("Ana", "001");

        d.adicionarAluno(a);
        assertEquals(1, d.qtdDeAlunos());
        assertTrue(a.getDisciplinas().contains(d));
    }

    @Test
    void testToString() {
        Horario h = new Horario(Dia.SEXTA, HoraAula._15_17);
        Disciplina d = new Disciplina("História", h);
        assertEquals("História (" + h + ")", d.toString());
    }
}

