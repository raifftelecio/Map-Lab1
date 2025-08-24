package com.lab1map;

import com.lab1map.entities.Aluno;
import com.lab1map.entities.Disciplina;
import com.lab1map.entities.Horario;
import com.lab1map.entities.Dia;
import com.lab1map.entities.HoraAula;
import com.lab1map.services.ControleAcademico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class AlunoTest {

    // criação do aluno e verificação inicial usando ControleAcademico
    @Test
    void testCriacaoAluno() {
        Aluno aluno = new Aluno("Raiff", "2023208510025");
        ControleAcademico controle = new ControleAcademico();
        assertEquals("Raiff", aluno.getNome());
        assertEquals("2023208510025", aluno.getMatricula());
        assertTrue(controle.disciplinasDoAluno(aluno).isEmpty());
    }

    @Test
    void testToString() {
        Aluno aluno = new Aluno("Guilherme", "2023208510005");
        assertEquals("Guilherme (2023208510005)", aluno.toString());
    }


    // garante que a disciplina foi adicionada ao aluno corretamente via
    // ControleAcademico
    @Test
    void testAdicionarDisciplina() {
        Aluno aluno = new Aluno("Raiff", "2023208510025");
        Disciplina disciplina1 = new Disciplina("MÉTODOS AVANÇADOS DE PROGEAMAÇÃO",
                new Horario(Dia.SEGUNDA, HoraAula._07_09));
        ControleAcademico controle = new ControleAcademico();

        controle.matricular(aluno, disciplina1);
        assertEquals(1, controle.disciplinasDoAluno(aluno).size());

        // verificação, pois não deve duplicar ao matricular novamente
        controle.matricular(aluno, disciplina1);
        assertEquals(1, controle.disciplinasDoAluno(aluno).size());
    }
}
