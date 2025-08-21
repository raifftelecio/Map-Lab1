package com.lab1map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ProfessorTest {

    @Test
    void testCriacaoProfessor() {
        Professor p = new Professor("Profa. Katia Elizabete Galdino", "katiagaldino@servidor.uepb.edu.br");
        assertEquals("Profa. Katia Elizabete Galdino", p.getNome());
        assertEquals("katiagaldino@servidor.uepb.edu.br", p.getEmail());
        assertTrue(p.getDisciplinas().isEmpty());
    }

    @Test
    void testAdicionarDisciplina() {
        Professor p = new Professor("Prof. Daniel Scherer", "scherer@servidor.uepb.edu.br");
        Disciplina d = new Disciplina("ANÁLISE E PROJETO DE SISTEMA", new Horario(Dia.SEGUNDA, HoraAula._07_09));

        p.adicionarDisciplina(d);
        assertEquals(1, p.getDisciplinas().size());
        assertEquals(d, p.getDisciplinas().get(0));
    }

    @Test
    void testToString() {
        Professor p = new Professor("Prof. Fábio Luiz Leite Júnior", "fabioleite@servidor.uepb.edu.br");
        assertEquals("Prof. Fábio Luiz Leite Júnior", p.toString());
    }
}

