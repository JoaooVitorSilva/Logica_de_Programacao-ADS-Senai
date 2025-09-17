package br.com.senai.Modulo2;

import java.util.Scanner;

public class SistemaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a nota da primeira prova: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Digite a nota da segunda prova: ");
        double nota2 = scanner.nextDouble();

        System.out.print("Digite a nota do trabalho: ");
        double trabalho = scanner.nextDouble();

        // Cálculo da média ponderada
        double media = (nota1 * 3 + nota2 * 3 + trabalho * 4) / 10;

        System.out.println("\n=== BOLETIM ===");
        System.out.println("Aluno: " + nome);
        System.out.printf("Média: %.2f\n", media);

        if (media >= 9.0) {
            System.out.println("Conceito: A - Excelente!");
        } else if (media >= 8.0) {
            System.out.println("Conceito: B - Muito Bom!");
        } else if (media >= 7.0) {
            System.out.println("Conceito: C - Bom!");
        } else if (media >= 6.0) {
            System.out.println("Conceito: D - Regular");
            System.out.println("Status: APROVADO (por pouco!)");
        } else {
            System.out.println("Conceito: F - Insuficiente");
            System.out.println("Status: REPROVADO");

            if (media >= 4.0) {
                System.out.println("Pode fazer recuperação!");
            } else {
                System.out.println("Deve cursar novamente a disciplina.");
            }
        }

        scanner.close();
    }
}