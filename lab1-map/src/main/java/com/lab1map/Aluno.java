package com.lab1map;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private String matricula;
    private List<Disciplina> disciplinas = new ArrayList<>();
    
    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getMatricula() {
        return matricula;
    }
    
    @Override
    public String toString() {
        return nome + " (" + matricula + ")";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aluno aluno = (Aluno) obj;
        return matricula.equals(aluno.matricula);
    }
    
    public void adicionarDisciplina(Disciplina disciplina) {
        if (!disciplinas.contains(disciplina)) {
            disciplinas.add(disciplina);
        }
    }
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
    @Override
    public int hashCode() {
        return matricula.hashCode();
    }
    
}
