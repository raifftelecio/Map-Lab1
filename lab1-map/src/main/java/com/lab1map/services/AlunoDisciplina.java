
package com.lab1map.services;

import com.lab1map.entities.Aluno;
import com.lab1map.entities.Disciplina;

/*
 Representa a matrícula de um aluno em uma disciplina.
*/
public class AlunoDisciplina {

    private final Aluno aluno;
    private final Disciplina disciplina;

    public AlunoDisciplina(Aluno aluno, Disciplina disciplina) {
        this.aluno = aluno;
        this.disciplina = disciplina;
    }

    public Aluno getAluno() {
        return aluno;
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
        AlunoDisciplina other = (AlunoDisciplina) obj;
        if (aluno == null || other.aluno == null)
            return false;
        if (disciplina == null || other.disciplina == null)
            return false;
        return aluno.getMatricula().equals(other.aluno.getMatricula())
                && disciplina.getNome().equals(other.disciplina.getNome())
                && disciplina.getHorario().toString().equals(other.disciplina.getHorario().toString());
    }

   
}
