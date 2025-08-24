package com.lab1map.services;

import com.lab1map.entities.Aluno;
import com.lab1map.entities.Disciplina;
import com.lab1map.entities.Professor;
import java.util.ArrayList;
import java.util.List;

public class ControleAcademico {
  private List<AlunoDisciplina> matriculas = new ArrayList<>();
  private List<ProfessorDisciplina> vinculos = new ArrayList<>();

  public void matricular(Aluno aluno, Disciplina disciplina) {
    AlunoDisciplina ad = new AlunoDisciplina(aluno, disciplina);
    if (!matriculas.contains(ad)) {
      matriculas.add(ad);
    }
  }

  public void vincularProfessor(Professor professor, Disciplina disciplina) {
    ProfessorDisciplina pd = new ProfessorDisciplina(professor, disciplina);
    if (!vinculos.contains(pd)) {
      vinculos.add(pd);
    }
  }

  public List<Disciplina> disciplinasDoAluno(Aluno aluno) {
    List<Disciplina> resultado = new ArrayList<>();
    for (AlunoDisciplina m : matriculas) {
      if (m.getAluno().equals(aluno)) {
        resultado.add(m.getDisciplina());
      }
    }
    return resultado;
  }

  public List<Aluno> alunosDaDisciplina(Disciplina disciplina) {
    List<Aluno> resultado = new ArrayList<>();
    for (AlunoDisciplina m : matriculas) {
      if (m.getDisciplina().equals(disciplina)) {
        resultado.add(m.getAluno());
      }
    }
    return resultado;
  }

  public Professor professorDaDisciplina(Disciplina disciplina) {
    for (ProfessorDisciplina v : vinculos) {
      if (v.getDisciplina().equals(disciplina)) {
        return v.getProfessor();
      }
    }
    return null;
  }

  public List<Disciplina> disciplinasDoProfessor(Professor professor) {
    List<Disciplina> resultado = new ArrayList<>();
    for (ProfessorDisciplina v : vinculos) {
      if (v.getProfessor().equals(professor)) {
        resultado.add(v.getDisciplina());
      }
    }
    return resultado;
  }

}
