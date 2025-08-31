package com.lab1map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.lab1map.entities.Aluno;
import com.lab1map.entities.Dia;
import com.lab1map.entities.Disciplina;
import com.lab1map.entities.HoraAula;
import com.lab1map.entities.Horario;
import com.lab1map.entities.Professor;
import com.lab1map.services.ControleAcademico;

class DisciplinaTest {
    
    @Test
    void criarDisciplina_nomeCorreto() {
        Disciplina disciplina = new Disciplina("MAP", new Horario(Dia.SEGUNDA, HoraAula._07_09));
        assertEquals("MAP", disciplina.getNome());
    }

    @Test
    void criarDisciplina_iniciaSemProfessor() {
        Disciplina disciplina = new Disciplina("MAP", new Horario(Dia.SEGUNDA, HoraAula._07_09));
        assertNull(disciplina.getProfessor());
    }

    @Test
    void criarDisciplina_horarioCorreto() {
        Horario horario = new Horario(Dia.SEGUNDA, HoraAula._07_09);
        Disciplina disciplina = new Disciplina("MAP", horario);
        assertEquals(horario, disciplina.getHorario());
    }

    @Test
    void vincularProfessor_funcionaCorretamente() {
        Professor professor = new Professor("Prof. Onildo", "onildo@uepb.edu");
        Disciplina disciplina = new Disciplina("MAP", new Horario(Dia.SEGUNDA, HoraAula._07_09));
        ControleAcademico controle = new ControleAcademico();


        controle.vincularProfessor(professor, disciplina);
        assertEquals(professor, controle.professorDaDisciplina(disciplina));
    }

    @Test
    void matricularAluno_disciplinaContemAluno() {
        Disciplina disciplina = new Disciplina("MAP", new Horario(Dia.SEGUNDA, HoraAula._07_09));
        Aluno aluno = new Aluno("Guilherme", "2023208510005");
        ControleAcademico controle = new ControleAcademico();

        controle.matricular(aluno, disciplina);
        assertTrue(controle.alunosDaDisciplina(disciplina).contains(aluno));
    }

    @Test
    void toString_formatacaoCorreta() {
        Horario horario = new Horario(Dia.SEGUNDA, HoraAula._11_13);
        Disciplina disciplina = new Disciplina("REDES", horario);
        assertEquals("REDES (" + horario + ")", disciplina.toString());
    }
}
