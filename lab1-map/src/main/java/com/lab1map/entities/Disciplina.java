package com.lab1map.entities;

import com.lab1map.services.AlunoDisciplina;
import com.lab1map.services.ProfessorDisciplina;

public class Disciplina {
    private String nome;
    private Professor professor;
    private Horario horario;

    public Disciplina(String nome, Horario horario) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome da disciplina não pode ser null ou vazio");
        }
        if (horario == null) {
            throw new IllegalArgumentException("Horario não pode ser null");
        }
        this.nome = nome;
        this.horario = horario;
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

    @Override
    public String toString() {
        return nome + " (" + horario + ")";
    }

    /**
     * Cria e retorna um vínculo de matrícula entre este disciplina e o aluno.
     * Responsabilidade: Disciplina cria o objeto AlunoDisciplina conforme o
     * padrão GRASP Creator.
     */
    public AlunoDisciplina matricularAluno(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não pode ser null");
        }
        return new AlunoDisciplina(aluno, this);
    }

    /**
     * Associa um professor a esta disciplina e cria o vínculo ProfessorDisciplina.
     * A disciplina passa a referenciar o professor e retorna o objeto de vínculo.
     */
    public ProfessorDisciplina atribuirProfessor(Professor professor) {
        if (professor == null) {
            throw new IllegalArgumentException("Professor não pode ser null");
        }
        this.professor = professor;
        return new ProfessorDisciplina(professor, this);
    }
}
