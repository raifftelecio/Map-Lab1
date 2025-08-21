package com.lab1map;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private Professor professor;
    private Horario horario;
    private List<Aluno> alunos;

    public Disciplina(String nome, Professor professor, Horario horario) {
        this.nome = nome;
        this.professor = professor;
        this.horario = horario;
        this.alunos = new ArrayList<>();
    }

    // Esse construtor é feito sem o professor, caso a disciplina seja criada antes de veincular ele
    public Disciplina(String nome, Horario horario) {
        this.nome = nome;
        this.horario = horario;
        this.alunos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Horario getHorario() {
        return horario;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }
  
    public int qtdDeAlunos() {
        return alunos.size();
    }

    public void printarAlunosMatriculados() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno matriculado na disciplina " + nome);
        } else {
            System.out.println("Alunos matriculados em " + nome + ":");
            for (Aluno aluno : alunos) {
                System.out.println(" - " + aluno.getNome());
            }
        }
    }

    @Override
    public String toString() {
        return nome + " (" + horario + ")";
    }

    public void adicionarAluno(Aluno aluno) {
      if (!alunos.contains(aluno)) {
          alunos.add(aluno);
          aluno.adicionarDisciplina(this);
      }
  }
  
}
