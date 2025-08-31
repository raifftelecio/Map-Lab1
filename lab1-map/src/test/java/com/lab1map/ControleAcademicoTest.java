package com.lab1map;

import java.util.List;

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

class ControleAcademicoTest {

    private ControleAcademico criarControleAcademicoComDisciplina(Disciplina disc, Aluno... alunos) {
        ControleAcademico controle = new ControleAcademico();
        for (Aluno aluno : alunos) {
            controle.matricular(aluno, disc);
        }
        return controle;
    }

    @Test
    void deveMatricularAlunoEmDisciplina() {
        Aluno aluno = new Aluno("Raiff Ferreira Telecio", "2023208510025");
        Disciplina disc = new Disciplina("REDES DE COMPUTADORES", new Horario(Dia.SEGUNDA, HoraAula._07_09));

        ControleAcademico controle = criarControleAcademicoComDisciplina(disc, aluno);

        List<Aluno> alunos = controle.alunosDaDisciplina(disc);
        assertEquals(1, alunos.size());
    }

    @Test
    void deveRetornarAlunosMatriculadosNaDisciplina() {
        Aluno a1 = new Aluno("Raiff Ferreira Telecio", "2023208510025");
        Aluno a2 = new Aluno("Guilherme Ribeiro Liebig", "2023208510005");
        Disciplina disc = new Disciplina("REDES DE COMPUTADORES", new Horario(Dia.SEGUNDA, HoraAula._07_09));

        ControleAcademico controle = criarControleAcademicoComDisciplina(disc, a1, a2);

        List<Aluno> alunos = controle.alunosDaDisciplina(disc);
        assertTrue(alunos.contains(a1) && alunos.contains(a2));
    }

    @Test
    void deveRetornarDisciplinasDeUmAluno() {
        Aluno aluno = new Aluno("Raiff Ferreira Telecio", "2023208510025");
        Disciplina disc = new Disciplina("REDES DE COMPUTADORES", new Horario(Dia.SEGUNDA, HoraAula._07_09));

        ControleAcademico controle = criarControleAcademicoComDisciplina(disc, aluno);

        List<Disciplina> disciplinas = controle.disciplinasDoAluno(aluno);
        assertEquals(1, disciplinas.size());
    }

    @Test
    void deveRetornarProfessorNuloQuandoNaoVinculado() {
        Disciplina disc = new Disciplina("REDES DE COMPUTADORES", new Horario(Dia.SEGUNDA, HoraAula._07_09));
        ControleAcademico controle = new ControleAcademico();

        assertNull(controle.professorDaDisciplina(disc));
    }

    @Test
    void deveVincularProfessorADisciplina() {
        Disciplina disc = new Disciplina("REDES DE COMPUTADORES", new Horario(Dia.SEGUNDA, HoraAula._07_09));
        Professor prof = new Professor("Prof. Dunfrey Pires Aragão", "dunfrey.aragao@servidor.uepb.edu.br");
        ControleAcademico controle = new ControleAcademico();

        controle.vincularProfessor(prof, disc);

        assertEquals(prof, controle.professorDaDisciplina(disc));
    }
}
