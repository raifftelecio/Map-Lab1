package com.lab1map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class DisciplinaTest {

    @Test
    void testCriacaoDisciplinaComProfessor() {
        Professor prof = new Professor("Prof. Onildo dos Reis Freire", "onildo@servidor.uepb.edu.br");
        Horario horario1 = new Horario(Dia.TERCA, HoraAula._09_11);
        Disciplina disciplina1 = new Disciplina("ÁLGEBRA LINEAR", prof, horario1);

        assertEquals("ÁLGEBRA LINEAR", disciplina1.getNome());
        assertEquals(prof, disciplina1.getProfessor());
        assertEquals(horario1, disciplina1.getHorario());
        assertTrue(disciplina1.getAlunos().isEmpty());
    }

    @Test
    void testCriacaoDisciplinaSemProfessor() {
        Horario horario2 = new Horario(Dia.QUARTA, HoraAula._11_13);
        Disciplina disciplina2 = new Disciplina("LINGUAGENS FORMAIS E TEORIA DA COMPUTAÇÃO", horario2);

        assertEquals("LINGUAGENS FORMAIS E TEORIA DA COMPUTAÇÃO", disciplina2.getNome());
        assertNull(disciplina2.getProfessor());
    }

    @Test
    void testAdicionarAluno() {
        Disciplina disciplina3 = new Disciplina("MÉTODOS AVANÇADOS DE PROGRAMAÇÃO", new Horario(Dia.SEXTA, HoraAula._07_09));
        Aluno aluno1 = new Aluno("Guilherme Ribeiro", "2023208510005");

        disciplina3.adicionarAluno(aluno1);
        assertEquals(1, disciplina3.qtdDeAlunos());
        assertTrue(aluno1.getDisciplinas().contains(disciplina3));
    }

    @Test
    void testToString() {
        Horario horario3 = new Horario(Dia.SEGUNDA, HoraAula._11_13);
        Disciplina disciplina3 = new Disciplina("REDES DE COMPUTADORES", horario3);
        assertEquals("REDES DE COMPUTADORES (" + horario3 + ")", disciplina3.toString());
    }
}

