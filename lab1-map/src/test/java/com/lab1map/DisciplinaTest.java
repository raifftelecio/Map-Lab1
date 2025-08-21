package com.lab1map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class DisciplinaTest {

    @Test
    void testCriacaoDisciplinaComProfessor() {
        Professor p = new Professor("Prof. Onildo dos Reis Freire", "onildo@servidor.uepb.edu.br");
        Horario h = new Horario(Dia.TERCA, HoraAula._09_11);
        Disciplina d = new Disciplina("ÁLGEBRA LINEAR", p, h);

        assertEquals("ÁLGEBRA LINEAR", d.getNome());
        assertEquals(p, d.getProfessor());
        assertEquals(h, d.getHorario());
        assertTrue(d.getAlunos().isEmpty());
    }

    @Test
    void testCriacaoDisciplinaSemProfessor() {
        Horario h = new Horario(Dia.QUARTA, HoraAula._11_13);
        Disciplina d = new Disciplina("LINGUAGENS FORMAIS E TEORIA DA COMPUTAÇÃO", h);

        assertEquals("LINGUAGENS FORMAIS E TEORIA DA COMPUTAÇÃO", d.getNome());
        assertNull(d.getProfessor());
    }

    @Test
    void testAdicionarAluno() {
        Disciplina d = new Disciplina("ESTRUTURA DE DADOS", new Horario(Dia.QUINTA, HoraAula._13_15));
        Aluno a = new Aluno("Ana", "001");

        d.adicionarAluno(a);
        assertEquals(1, d.qtdDeAlunos());
        assertTrue(a.getDisciplinas().contains(d));
    }

    @Test
    void testToString() {
        Horario h = new Horario(Dia.SEXTA, HoraAula._15_17);
        Disciplina d = new Disciplina("LABORATÓRIO DE ESTRUTURA DE DADOS", h);
        assertEquals("LABORATÓRIO DE ESTRUTURA DE DADOS (" + h + ")", d.toString());
    }
}

