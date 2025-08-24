package com.lab1map.entities;

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
}
