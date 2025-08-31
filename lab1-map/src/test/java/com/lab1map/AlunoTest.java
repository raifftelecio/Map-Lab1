package com.lab1map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.lab1map.entities.Aluno;
import com.lab1map.entities.Dia;
import com.lab1map.entities.Disciplina;
import com.lab1map.entities.HoraAula;
import com.lab1map.entities.Horario;
import com.lab1map.services.ControleAcademico;

class AlunoTest {
    
    @Test
    void criarAluno_retornaNomeCorreto() {
        Aluno aluno = new Aluno("Raiff", "2023208510025");
        assertEquals("Raiff", aluno.getNome());
    }

    @Test
    void criarAluno_retornaMatriculaCorreta() {
        Aluno aluno = new Aluno("Raiff", "2023208510025");
        assertEquals("2023208510025", aluno.getMatricula());
    }

    @Test
    void novoAluno_possuiListaDisciplinasVazia() {
        Aluno aluno = new Aluno("Raiff", "2023208510025");
        ControleAcademico controle = new ControleAcademico();
        assertTrue(controle.disciplinasDoAluno(aluno).isEmpty());
    }

    @Test
    void toString_retornaFormatacaoCorreta() {
        Aluno aluno = new Aluno("Guilherme", "2023208510005");
        assertEquals("Guilherme (2023208510005)", aluno.toString());
    }

    @Test
    void matricularAluno_disciplinaAdicionadaComSucesso() {
        Aluno aluno = new Aluno("Raiff", "2023208510025");
        Disciplina disciplina = new Disciplina("MAP", new Horario(Dia.SEGUNDA, HoraAula._07_09));
        ControleAcademico controle = new ControleAcademico();

        controle.matricular(aluno, disciplina);
        assertEquals(1, controle.disciplinasDoAluno(aluno).size());
    }

    @Test
    void matricularAluno_naoDuplicaDisciplina() {
        Aluno aluno = new Aluno("Raiff", "2023208510025");
        Disciplina disciplina = new Disciplina("MAP", new Horario(Dia.SEGUNDA, HoraAula._07_09));
        ControleAcademico controle = new ControleAcademico();

        controle.matricular(aluno, disciplina);
        controle.matricular(aluno, disciplina);
        assertEquals(1, controle.disciplinasDoAluno(aluno).size());
    }
}
