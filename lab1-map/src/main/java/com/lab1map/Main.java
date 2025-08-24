
package com.lab1map;

import com.lab1map.entities.Aluno;
import com.lab1map.entities.Professor;
import com.lab1map.entities.Disciplina;
import com.lab1map.services.ControleAcademico;
import com.lab1map.entities.Horario;
import com.lab1map.entities.Dia;
import com.lab1map.entities.HoraAula;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TESTE DO SISTEMA DE CONTROLE ACADÊMICO ===\n");

        // Primeiro criamos os professores
        System.out.println("1. CRIANDO PROFESSORES:");
        Professor prof1 = new Professor("Profa. Sabrina de Figueirêdo Souto", "sabrinadfs@servidor.uepb.edu.br");
        Professor prof2 = new Professor("Prof. Dunfrey Pires Aragão", "dunfrey.aragao@servidor.uepb.edu.br");
        Professor prof3 = new Professor("Prof. Israel Burití Galvão", "israelbg@servidor.uepb.edu.br");

        System.out.println("Professor 1: " + prof1 + " (" + prof1.getEmail() + ")");
        System.out.println("Professor 2: " + prof2 + " (" + prof2.getEmail() + ")");
        System.out.println("Professor 3: " + prof3 + " (" + prof3.getEmail() + ")");
        System.out.println();

        // Depois criamos os horários
        System.out.println("2. CRIANDO HORÁRIOS:");
        Horario horario1 = new Horario(Dia.SEGUNDA, HoraAula._07_09);
        Horario horario2 = new Horario(Dia.QUARTA, HoraAula._09_11);
        Horario horario3 = new Horario(Dia.QUINTA, HoraAula._09_11);
        Horario horario4 = new Horario(Dia.TERCA, HoraAula._11_13);

        System.out.println("Horário 1: " + horario1);
        System.out.println("Horário 2: " + horario2);
        System.out.println("Horário 3: " + horario3);
        System.out.println("Horário 4: " + horario4);
        System.out.println();

        // Criamos disciplinas
        System.out.println("3. CRIANDO DISCIPLINAS:");
        Disciplina disc1 = new Disciplina("Métodos Avançados de Programação ", horario1);
        Disciplina disc2 = new Disciplina("Redes de Computadores", horario2);
        Disciplina disc3 = new Disciplina("Calculo 3", horario3);
        Disciplina disc4 = new Disciplina("Banco de Dados", horario4); // Sem professor no momento (suposição)
        System.out.println("Disciplina 1: " + disc1);
        System.out.println("Disciplina 2: " + disc2);
        System.out.println("Disciplina 3: " + disc3);
        System.out.println("Disciplina 4: " + disc4 + " (sem professor)");
        System.out.println();

        // Associando disciplinas aos professores via serviço
        System.out.println("4. ASSOCIANDO DISCIPLINAS AOS PROFESSORES:");
        ControleAcademico controle = new ControleAcademico();
        controle.vincularProfessor(prof1, disc1);
        controle.vincularProfessor(prof2, disc2);
        controle.vincularProfessor(prof3, disc3);

        System.out.println("Disciplinas do " + prof1.getNome() + ": " + controle.disciplinasDoProfessor(prof1).size());
        System.out.println("Disciplinas da " + prof2.getNome() + ": " + controle.disciplinasDoProfessor(prof2).size());
        System.out.println("Disciplinas do " + prof3.getNome() + ": " + controle.disciplinasDoProfessor(prof3).size());
        System.out.println();

        // Criando alunos
        System.out.println("5. CRIANDO ALUNOS:");
        Aluno aluno1 = new Aluno("Guilherme Ribeiro", "20232085100005");
        Aluno aluno2 = new Aluno("Raiff Telécio", "2023208510025");
        Aluno aluno3 = new Aluno("Vinicius Souto", "2023208510012");

        System.out.println("Aluno 1: " + aluno1);
        System.out.println("Aluno 2: " + aluno2);
        System.out.println("Aluno 3: " + aluno3);

        System.out.println();

        // Matriculando alunos nas disciplinas
        System.out.println("6. MATRICULANDO ALUNOS NAS DISCIPLINAS:");

        controle.matricular(aluno1, disc1);
        controle.matricular(aluno2, disc1);
        controle.matricular(aluno3, disc1);

        controle.matricular(aluno2, disc2);
        controle.matricular(aluno3, disc2);

        controle.matricular(aluno1, disc3);

        System.out.println("Matrículas realizadas com sucesso!");
        System.out.println();

        // Agora verificamos a quantidade dos alunos nas disciplinas
        System.out.println("7. QUANTIDADE DE ALUNOS POR DISCIPLINA:");
        System.out.println(disc1.getNome() + ": " + controle.alunosDaDisciplina(disc1).size() + " alunos");
        System.out.println(disc2.getNome() + ": " + controle.alunosDaDisciplina(disc2).size() + " alunos");
        System.out.println(disc3.getNome() + ": " + controle.alunosDaDisciplina(disc3).size() + " alunos");
        System.out.println(disc4.getNome() + ": " + controle.alunosDaDisciplina(disc4).size() + " alunos");
        System.out.println();

        // Verificando os alunos nas disciplinas
        System.out.println("8. LISTANDO ALUNOS MATRICULADOS:");
        for (Aluno a : controle.alunosDaDisciplina(disc1))
            System.out.println("- " + a);
        System.out.println();
        for (Aluno a : controle.alunosDaDisciplina(disc2))
            System.out.println("- " + a);
        System.out.println();
        for (Aluno a : controle.alunosDaDisciplina(disc3))
            System.out.println("- " + a);
        System.out.println();
        for (Aluno a : controle.alunosDaDisciplina(disc4))
            System.out.println("- " + a);
        System.out.println();

        // Testando disciplinas de cada aluno
        System.out.println("9. DISCIPLINAS POR ALUNO:");
        System.out
                .println(aluno1.getNome() + " está matriculado em " + controle.disciplinasDoAluno(aluno1).size()
                        + " disciplinas:");
        for (Disciplina d : controle.disciplinasDoAluno(aluno1)) {
            System.out.println("  - " + d.getNome() + " (" + d.getHorario() + ")");
        }
        System.out.println();
        System.out
                .println(aluno2.getNome() + " está matriculado em " + controle.disciplinasDoAluno(aluno2).size()
                        + " disciplinas:");
        for (Disciplina d : controle.disciplinasDoAluno(aluno2)) {
            System.out.println("  - " + d.getNome() + " (" + d.getHorario() + ")");
        }
        System.out.println();

    }
}
