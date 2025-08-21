package com.lab1map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ProfessorTest {

    @Test
    void testCriacaoProfessor() {
        Professor prof1 = new Professor("Profa. Sabrina de Figueirêdo Souto", "sabrinadfs@servidor.uepb.edu.br");
        assertEquals("Profa. Sabrina de Figueirêdo Souto", prof1.getNome());
        assertEquals("sabrinadfs@servidor.uepb.edu.br", prof1.getEmail());
        assertTrue(prof1.getDisciplinas().isEmpty());
    }

    @Test
    void testAdicionarDisciplina() {
        Professor prof2 = new Professor("Prof. Daniel Scherer", "scherer@servidor.uepb.edu.br");
        Disciplina disciplina2 = new Disciplina("ANÁLISE E PROJETO DE SISTEMA", new Horario(Dia.QUARTA, HoraAula._07_09));

        prof2.adicionarDisciplina(disciplina2);
        assertEquals(1, prof2.getDisciplinas().size());
        assertEquals(disciplina2, prof2.getDisciplinas().get(0));
    }

    @Test
    void testToString() {
        Professor prof3 = new Professor("Prof. Fábio Luiz Leite Júnior", "fabioleite@servidor.uepb.edu.br");
        assertEquals("Prof. Fábio Luiz Leite Júnior", prof3.toString());
    }
}

