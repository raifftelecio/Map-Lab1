package com.lab1map;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String nome;
    private String email;
    private List<Disciplina> disciplinas = new ArrayList<>();

    public Professor(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    @Override
    public String toString() {
        return nome;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}
