package com.lab1map;

import com.lab1map.entities.Aluno;
import com.lab1map.entities.Disciplina;
import com.lab1map.entities.Horario;
import com.lab1map.entities.Dia;
import com.lab1map.entities.HoraAula;
import com.lab1map.entities.Professor;
import com.lab1map.services.ControleAcademico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import java.util.List;

class ControleAcademicoTest {
  

  @Test
  void testMatriculaEConsultas() {
    ControleAcademico controle = new ControleAcademico();

    Professor prof = new Professor("Prof. Teste", "teste@ex.com");
    Horario h = new Horario(Dia.SEGUNDA, HoraAula._07_09);
    Disciplina disc = new Disciplina("DISC TEST", h);

    Aluno a1 = new Aluno("Aluno 1", "2023001");
    Aluno a2 = new Aluno("Aluno 2", "2023002");

    controle.matricular(a1, disc);
    controle.matricular(a2, disc);

    List<Aluno> alunos = controle.alunosDaDisciplina(disc);
    assertEquals(2, alunos.size());
    assertTrue(alunos.contains(a1) && alunos.contains(a2));

    List<Disciplina> disciplinasA1 = controle.disciplinasDoAluno(a1);
    assertEquals(1, disciplinasA1.size());
    assertEquals(disc, disciplinasA1.get(0));

    // professor ainda não vinculado via serviço
    assertNull(controle.professorDaDisciplina(disc));

    // vincular professor e checar
    controle.vincularProfessor(prof, disc);
    assertEquals(prof, controle.professorDaDisciplina(disc));
  }
}
