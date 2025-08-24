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
  

  @Test
  void testMatriculaEConsultas() {
    ControleAcademico controle = new ControleAcademico();

    Professor prof = new Professor("Prof. Dunfrey Pires Aragão", "dunfrey.aragao@servidor.uepb.edu.br");
    Horario horario = new Horario(Dia.SEGUNDA, HoraAula._07_09);
    Disciplina disc = new Disciplina("REDES DE COMPUTADORES", horario);

    Aluno a1 = new Aluno("Raiff Ferreira Telecio", "2023208510025");
    Aluno a2 = new Aluno("Guilherme Ribeiro Liebig", "2023208510005");

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
