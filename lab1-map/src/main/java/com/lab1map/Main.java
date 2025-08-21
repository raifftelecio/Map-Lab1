package com.lab1map;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TESTE DO SISTEMA DE GERENCIAMENTO ESCOLAR ===\n");
        
        // Criando professores
        System.out.println("1. CRIANDO PROFESSORES:");
        Professor prof1 = new Professor("Profa. Sabrina de Figueirêdo Souto", "sabrinadfs@servidor.uepb.edu.br");
        Professor prof2 = new Professor("Prof. Dunfrey Pires Aragão", "dunfrey.aragao@servidor.uepb.edu.br");
        Professor prof3 = new Professor("Prof. Israel Burití Galvão", "israelbg@servidor.uepb.edu.br");
        
        System.out.println("Professor 1: " + prof1 + " (" + prof1.getEmail() + ")");
        System.out.println("Professor 2: " + prof2 + " (" + prof2.getEmail() + ")");
        System.out.println("Professor 3: " + prof3 + " (" + prof3.getEmail() + ")");
        System.out.println();
        
        // Criando horários
        System.out.println("2. CRIANDO HORÁRIOS:");
        Horario horario1 = new Horario(Dia.SEGUNDA, HoraAula._07_09);
        Horario horario2 = new Horario(Dia.TERCA, HoraAula._09_11);
        Horario horario3 = new Horario(Dia.QUARTA, HoraAula._13_15);
        Horario horario4 = new Horario(Dia.QUINTA, HoraAula._15_17);
        
        System.out.println("Horário 1: " + horario1);
        System.out.println("Horário 2: " + horario2);
        System.out.println("Horário 3: " + horario3);
        System.out.println("Horário 4: " + horario4);
        System.out.println();
        
        // Criando disciplinas
        System.out.println("3. CRIANDO DISCIPLINAS:");
        Disciplina disc1 = new Disciplina("Programação Orientada a Objetos", prof1, horario1);
        Disciplina disc2 = new Disciplina("Estruturas de Dados", prof2, horario2);
        Disciplina disc3 = new Disciplina("Banco de Dados", prof3, horario3);
        Disciplina disc4 = new Disciplina("Algoritmos Avançados", horario4); // Sem professor inicialmente
        
        System.out.println("Disciplina 1: " + disc1);
        System.out.println("Disciplina 2: " + disc2);
        System.out.println("Disciplina 3: " + disc3);
        System.out.println("Disciplina 4: " + disc4 + " (sem professor)");
        System.out.println();
        
        // Associando disciplinas aos professores
        System.out.println("4. ASSOCIANDO DISCIPLINAS AOS PROFESSORES:");
        prof1.adicionarDisciplina(disc1);
        prof2.adicionarDisciplina(disc2);
        prof3.adicionarDisciplina(disc3);
        
        System.out.println("Disciplinas do " + prof1.getNome() + ": " + prof1.getDisciplinas().size());
        System.out.println("Disciplinas da " + prof2.getNome() + ": " + prof2.getDisciplinas().size());
        System.out.println("Disciplinas do " + prof3.getNome() + ": " + prof3.getDisciplinas().size());
        System.out.println();
        
        // Criando alunos
        System.out.println("5. CRIANDO ALUNOS:");
        Aluno aluno1 = new Aluno("Guilherme Ribeiro", "2025001");
        Aluno aluno2 = new Aluno("Raiff Telécio", "2025002");
        Aluno aluno3 = new Aluno("Vinicius Souto", "2025003");
        Aluno aluno4 = new Aluno("Vinicius Lopes", "2025004");
        Aluno aluno5 = new Aluno("Gabriel Levy", "2025005");
        
        System.out.println("Aluno 1: " + aluno1);
        System.out.println("Aluno 2: " + aluno2);
        System.out.println("Aluno 3: " + aluno3);
        System.out.println("Aluno 4: " + aluno4);
        System.out.println("Aluno 5: " + aluno5);
        System.out.println();
        
        // Matriculando alunos nas disciplinas
        System.out.println("6. MATRICULANDO ALUNOS NAS DISCIPLINAS:");
        
        // POO
        disc1.adicionarAluno(aluno1);
        disc1.adicionarAluno(aluno2);
        disc1.adicionarAluno(aluno3);
        
        // Estruturas de Dados
        disc2.adicionarAluno(aluno2);
        disc2.adicionarAluno(aluno3);
        disc2.adicionarAluno(aluno4);
        disc2.adicionarAluno(aluno5);
        
        // Banco de Dados
        disc3.adicionarAluno(aluno1);
        disc3.adicionarAluno(aluno4);
        disc3.adicionarAluno(aluno5);
        
        System.out.println("Matrículas realizadas com sucesso!");
        System.out.println();
        
        // Testando quantidade de alunos por disciplina
        System.out.println("7. QUANTIDADE DE ALUNOS POR DISCIPLINA:");
        System.out.println(disc1.getNome() + ": " + disc1.qtdDeAlunos() + " alunos");
        System.out.println(disc2.getNome() + ": " + disc2.qtdDeAlunos() + " alunos");
        System.out.println(disc3.getNome() + ": " + disc3.qtdDeAlunos() + " alunos");
        System.out.println(disc4.getNome() + ": " + disc4.qtdDeAlunos() + " alunos");
        System.out.println();
        
        // Listando alunos matriculados em cada disciplina
        System.out.println("8. LISTANDO ALUNOS MATRICULADOS:");
        disc1.printarAlunosMatriculados();
        System.out.println();
        disc2.printarAlunosMatriculados();
        System.out.println();
        disc3.printarAlunosMatriculados();
        System.out.println();
        disc4.printarAlunosMatriculados();
        System.out.println();
        
        // Testando disciplinas de cada aluno
        System.out.println("9. DISCIPLINAS POR ALUNO:");
        System.out.println(aluno1.getNome() + " está matriculado em " + aluno1.getDisciplinas().size() + " disciplinas:");
        for (Disciplina d : aluno1.getDisciplinas()) {
            System.out.println("  - " + d.getNome() + " (" + d.getHorario() + ")");
        }
        System.out.println();
        
        System.out.println(aluno2.getNome() + " está matriculado em " + aluno2.getDisciplinas().size() + " disciplinas:");
        for (Disciplina d : aluno2.getDisciplinas()) {
            System.out.println("  - " + d.getNome() + " (" + d.getHorario() + ")");
        }
        System.out.println();
        
        // Testando método equals dos alunos
        System.out.println("10. TESTANDO MÉTODO EQUALS:");
        Aluno alunoTeste = new Aluno("Ana Costa Duplicada", "2024001"); // Mesma matrícula
        System.out.println("Aluno original: " + aluno1);
        System.out.println("Aluno teste: " + alunoTeste);
        System.out.println("São iguais (mesmo matrícula)? " + aluno1.equals(alunoTeste));
        System.out.println();
        
        // Tentando adicionar aluno duplicado
        System.out.println("11. TESTANDO ADIÇÃO DE ALUNO DUPLICADO:");
        System.out.println("Tentando adicionar aluno com matrícula duplicada em POO...");
        int qtdAntes = disc1.qtdDeAlunos();
        disc1.adicionarAluno(alunoTeste);
        int qtdDepois = disc1.qtdDeAlunos();
        System.out.println("Quantidade antes: " + qtdAntes);
        System.out.println("Quantidade depois: " + qtdDepois);
        System.out.println("Adição foi bloqueada? " + (qtdAntes == qtdDepois));
        System.out.println();
        
        // Testando todos os dias e horários
        System.out.println("12. TESTANDO TODOS OS DIAS E HORÁRIOS:");
        System.out.println("Dias disponíveis:");
        for (Dia dia : Dia.values()) {
            System.out.println("  - " + dia);
        }
        System.out.println();
        
        System.out.println("Horários disponíveis:");
        for (HoraAula hora : HoraAula.values()) {
            System.out.println("  - " + hora);
        }
        System.out.println();
        
        // Criando um horário para cada combinação
        System.out.println("13. EXEMPLO DE GRADE COMPLETA:");
        System.out.println("Segunda-feira:");
        System.out.println("  " + new Horario(Dia.SEGUNDA, HoraAula._07_09));
        System.out.println("  " + new Horario(Dia.SEGUNDA, HoraAula._09_11));
        System.out.println("  " + new Horario(Dia.SEGUNDA, HoraAula._11_13));
        System.out.println("  " + new Horario(Dia.SEGUNDA, HoraAula._13_15));
        System.out.println("  " + new Horario(Dia.SEGUNDA, HoraAula._15_17));
        System.out.println();
        
        System.out.println("=== TESTE CONCLUÍDO COM SUCESSO! ===");
    }
}
