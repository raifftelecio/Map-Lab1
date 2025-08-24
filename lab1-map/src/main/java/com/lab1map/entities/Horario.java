package com.lab1map.entities;


public class Horario {
    private Dia dia;
    private HoraAula hora;

    public Horario(Dia dia, HoraAula hora) {
        this.dia = dia;
        this.hora = hora;
    }

    public Dia getDia() {
        return dia;
    }

    public HoraAula getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return dia + " - " + hora;
    }
}
