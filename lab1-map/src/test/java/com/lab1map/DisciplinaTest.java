package com.lab1map;

import com.lab1map.entities.Aluno;
import com.lab1map.entities.Disciplina;
import com.lab1map.entities.Horario;
import com.lab1map.entities.Dia;
import com.lab1map.entities.HoraAula;
import com.lab1map.entities.Professor;
import com.lab1map.services.ControleAcademico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class DisciplinaTest {

    // valida a criação de uma disciplina e vínculo com professor via serviço
    @Test
    void testCriacaoDisciplinaComProfessor() {
        Professor prof = new Professor("Prof. Onildo dos Reis Freire", "onildo@servidor.uepb.edu.br");
        Horario horario1 = new Horario(Dia.TERCA, HoraAula._09_11);
        Disciplina disciplina1 = new Disciplina("ÁLGEBRA LINEAR", horario1);

        assertEquals("ÁLGEBRA LINEAR", disciplina1.getNome());
        assertNull(disciplina1.getProfessor());
        assertEquals(horario1, disciplina1.getHorario());

        ControleAcademico controle = new ControleAcademico();
        assertTrue(controle.alunosDaDisciplina(disciplina1).isEmpty());

        controle.vincularProfessor(prof, disciplina1);
        assertEquals(prof, controle.professorDaDisciplina(disciplina1));
    }

    // tenta criar a disciplina, que inicialmente não tem professor
    @Test
    void testCriacaoDisciplinaSemProfessor() {
        Horario horario2 = new Horario(Dia.QUARTA, HoraAula._11_13);
        Disciplina disciplina2 = new Disciplina("LINGUAGENS FORMAIS E TEORIA DA COMPUTAÇÃO", horario2);

        assertEquals("LINGUAGENS FORMAIS E TEORIA DA COMPUTAÇÃO", disciplina2.getNome());
        assertNull(disciplina2.getProfessor());
    }

    // verifica se ao adicionar aluno a disciplina via serviço, ele adiciona
    // corretamente
    @Test
    void testAdicionarAluno() {
        Disciplina disciplina3 = new Disciplina("MÉTODOS AVANÇADOS DE PROGRAMAÇÃO",
                new Horario(Dia.SEXTA, HoraAula._07_09));
        Aluno aluno1 = new Aluno("Guilherme Ribeiro", "2023208510005");

        ControleAcademico controle = new ControleAcademico();
        controle.matricular(aluno1, disciplina3);
        assertEquals(1, controle.alunosDaDisciplina(disciplina3).size());
        assertTrue(controle.alunosDaDisciplina(disciplina3).contains(aluno1));
    }

    // validando o método toString da classe Disciplina
    @Test
    void testToString() {
        Horario horario3 = new Horario(Dia.SEGUNDA, HoraAula._11_13);
        Disciplina disciplina3 = new Disciplina("REDES DE COMPUTADORES", horario3);
        assertEquals("REDES DE COMPUTADORES (" + horario3 + ")", disciplina3.toString());
    }
}
