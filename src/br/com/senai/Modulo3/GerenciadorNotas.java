package br.com.senai.Modulo3;

import java.util.Scanner;

public class GerenciadorNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos alunos tem na turma? ");
        int quantidadeAlunos = scanner.nextInt();

        String[] nomes = new String[quantidadeAlunos];
        double[] notas = new double[quantidadeAlunos];
        scanner.nextLine();

        for (int i = 0; i < quantidadeAlunos; i++) {
            System.out.print("Digite o nome do " + (i + 1) + "º aluno: ");
            nomes[i] = scanner.nextLine();

            System.out.print("Digite a nota de " + nomes[i] + ": ");
            notas[i] = scanner.nextDouble();
            scanner.nextLine();
        }

        double somaNotas = 0;
        double maiorNota = notas[0];
        double menorNota = notas[0];
        String alunoMaiorNota = nomes[0];
        String alunoMenorNota = nomes[0];

        for (int i = 0; i < quantidadeAlunos; i++) {
            somaNotas += notas[i];

            if (notas[i] > maiorNota) {
                maiorNota = notas[i];
                alunoMaiorNota = nomes[i];
            }

            if (notas[i] < menorNota) {
                menorNota = notas[i];
                alunoMenorNota = nomes[i];
            }
        }

        double mediaGeral = somaNotas / quantidadeAlunos;

        System.out.println("\n=== RELATÓRIO DA TURMA ===");
        System.out.printf("Média geral da turma: %.2f\n", mediaGeral);
        System.out.println("Maior nota: " + maiorNota + " - " + alunoMaiorNota);
        System.out.println("Menor nota: " + menorNota + " - " + alunoMenorNota);

        System.out.println("\n=== SITUAÇÃO INDIVIDUAL ===");
        int aprovados = 0, reprovados = 0;

        for (int i = 0; i < quantidadeAlunos; i++) {
            String situacao = notas[i] >= 7.0 ? "APROVADO" : "REPROVADO";
            System.out.printf("%s: %.2f - %s\n", nomes[i], notas[i], situacao);

            if (notas[i] >= 7.0) {
                aprovados++;
            } else {
                reprovados++;
            }
        }

        System.out.println("\n=== ESTATÍSTICAS FINAIS ===");
        System.out.println("Aprovados: " + aprovados);
        System.out.println("Reprovados: " + reprovados);
        System.out.printf("Taxa de aprovação: %.2f%%\n", (aprovados * 100.0) / quantidadeAlunos);

        scanner.close();
    }
}