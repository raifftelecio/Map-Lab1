
package com.lab1map.services;

import com.lab1map.entities.Disciplina;
import com.lab1map.entities.Professor;

public class ProfessorDisciplina {

    private Professor professor;
    private Disciplina disciplina;

    public ProfessorDisciplina(Professor professor, Disciplina disciplina) {
        this.professor = professor;
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ProfessorDisciplina other = (ProfessorDisciplina) obj;
        if (professor == null || other.professor == null)
            return false;
        if (disciplina == null || other.disciplina == null)
            return false;
        return professor.getEmail().equals(other.professor.getEmail())
                && disciplina.getNome().equals(other.disciplina.getNome())
                && disciplina.getHorario().toString().equals(other.disciplina.getHorario().toString());
    }
}