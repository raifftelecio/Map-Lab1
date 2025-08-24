package com.lab1map;

import com.lab1map.entities.Disciplina;
import com.lab1map.entities.Horario;
import com.lab1map.entities.Dia;
import com.lab1map.entities.HoraAula;
import com.lab1map.entities.Professor;
import com.lab1map.services.ControleAcademico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ProfessorTest {

    // valida a criação de um professor
    @Test
    void testCriacaoProfessor() {
        Professor prof1 = new Professor("Profa. Sabrina de Figueirêdo Souto", "sabrinadfs@servidor.uepb.edu.br");
        assertEquals("Profa. Sabrina de Figueirêdo Souto", prof1.getNome());
        assertEquals("sabrinadfs@servidor.uepb.edu.br", prof1.getEmail());
        // Sem lista de disciplinas na entidade: garantimos que nenhum vínculo existe no
        // serviço
        ControleAcademico controle = new ControleAcademico();
        assertTrue(controle.disciplinasDoAluno(new com.lab1map.entities.Aluno("x", "0")).isEmpty());
    }

    // testando a adição de uma disciplina ao professor via serviço
    @Test
    void testAdicionarDisciplina() {
        Professor prof2 = new Professor("Prof. Daniel Scherer", "scherer@servidor.uepb.edu.br");
        Disciplina disciplina2 = new Disciplina("ANÁLISE E PROJETO DE SISTEMA",
                new Horario(Dia.QUARTA, HoraAula._07_09));

        ControleAcademico controle = new ControleAcademico();
        controle.vincularProfessor(prof2, disciplina2);
        assertEquals(prof2, controle.professorDaDisciplina(disciplina2));
    }

    // Só verificando o método toString, se a saida ocorre como esperado.
    @Test
    void testToString() {
        Professor prof3 = new Professor("Prof. Fábio Luiz Leite Júnior", "fabioleite@servidor.uepb.edu.br");
        assertEquals("Prof. Fábio Luiz Leite Júnior", prof3.toString());
    }
}
