package com.lab1map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.lab1map.entities.Dia;
import com.lab1map.entities.Disciplina;
import com.lab1map.entities.HoraAula;
import com.lab1map.entities.Horario;
import com.lab1map.entities.Professor;
import com.lab1map.services.ControleAcademico;

class ProfessorTest {
    
    @Test
    void criarProfessor_nomeCorreto() {
        Professor professor = new Professor("Sabrina", "sabrina@servidor.uepb.edu.br");
        assertEquals("Sabrina", professor.getNome());
    }

    @Test
    void criarProfessor_emailCorreto() {
        Professor professor = new Professor("Sabrina", "sabrina@uepb.edu");
        assertEquals("sabrina@uepb.edu", professor.getEmail());
    }

    @Test
    void vincularDisciplina_funcionaCorretamente() {
        Professor professor = new Professor("Daniel", "daniel@servidor.uepb.edu.br");
        Disciplina disciplina = new Disciplina("APS", new Horario(Dia.QUARTA, HoraAula._07_09));
        ControleAcademico controle = new ControleAcademico();

        controle.vincularProfessor(professor, disciplina);
        assertEquals(professor, controle.professorDaDisciplina(disciplina));
    }

    @Test
    void toString_formatacaoCorreta() {
        Professor professor = new Professor("Fábio", "fabioleite@servidor.uepb.edu.br");
        assertEquals("Fábio", professor.toString());
    }
}
