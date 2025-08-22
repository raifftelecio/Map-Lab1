package com.lab1map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class Erro {

  @Test
  void testErrorCriacaoAluno() {
    Aluno aluno = new Aluno("Raiff", "2023208510025");
    assertEquals("Raiff", aluno.getNome());
    assertEquals("2023208510012", aluno.getMatricula());
    assertTrue(aluno.getDisciplinas().isEmpty());
  }

  @Test
  void testAdicionarDisciplina() {
    Professor prof2 = new Professor("Prof. Daniel Scherer", "scherer@servidor.uepb.edu.br");
    Disciplina disciplina2 = new Disciplina("ANÁLISE E PROJETO DE SISTEMA", new Horario(Dia.QUARTA, HoraAula._07_09));

    prof2.adicionarDisciplina(disciplina2);
    assertEquals(2, prof2.getDisciplinas().size());
  }
}
