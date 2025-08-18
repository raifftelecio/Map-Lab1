package com.lab1map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class AlunoTest {

    @Test
    void testCriacaoAluno() {
        Aluno aluno = new Aluno("Raiff", "2023208510025");
        assertEquals("Raiff", aluno.getNome());
        assertEquals("2023208510025", aluno.getMatricula());
        assertTrue(aluno.getDisciplinas().isEmpty());
    }

    @Test
    void testToString() {
        Aluno aluno = new Aluno("Guilherme", "2023208510005");
        assertEquals("Guilherme (2023208510005)", aluno.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        Aluno a1 = new Aluno("Vinicius", "2023208510012");
        Aluno a2 = new Aluno("Carlos", "2023208510012");
        assertEquals(a1, a2);
        assertEquals(a1.hashCode(), a2.hashCode());
    }

    @Test
    void testAdicionarDisciplina() {
        Aluno aluno = new Aluno("Raiff", "2023208510025");
        Disciplina d = new Disciplina("POO", new Horario(Dia.SEGUNDA, HoraAula._07_09));

        aluno.adicionarDisciplina(d);
        assertEquals(1, aluno.getDisciplinas().size());

        // Não deve duplicar
        aluno.adicionarDisciplina(d);
        assertEquals(1, aluno.getDisciplinas().size());
    }
}


