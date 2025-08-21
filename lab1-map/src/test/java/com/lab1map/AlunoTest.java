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
        Aluno aluno1 = new Aluno("Vinicius Souto", "2023208510012");
        Aluno aluno2 = new Aluno("Carlos Aleatório", "2023208510012");
        assertEquals(aluno1, aluno2);
        assertEquals(aluno1.hashCode(), aluno2.hashCode());
    }

    @Test
    void testAdicionarDisciplina() {
        Aluno aluno = new Aluno("Raiff", "2023208510025");
        Disciplina disciplina1 = new Disciplina("MÉTODOS AVANÇADOS DE PROGEAMAÇÃO", new Horario(Dia.SEGUNDA, HoraAula._07_09));

        aluno.adicionarDisciplina(disciplina1);
        assertEquals(1, aluno.getDisciplinas().size());

        // verificação, pois não deve duplicar
        aluno.adicionarDisciplina(disciplina1);
        assertEquals(1, aluno.getDisciplinas().size());
    }
}


