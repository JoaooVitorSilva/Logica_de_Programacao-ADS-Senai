package br.com.senai.Modulo1;

import java.util.Scanner;

public class EntradaSaida {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Sistema de Cadastro ===");

        System.out.print("Nome completo: ");
        String nomeCompleto = input.nextLine();

        System.out.print("Idade: ");
        int idade = input.nextInt();

        System.out.print("Salário: ");
        double salario = input.nextDouble();

        System.out.print("Tem filhos? (true/false): ");
        boolean temFilhos = input.nextBoolean();

        input.nextLine();

        System.out.print("Observações: ");
        String observacoes = input.nextLine();

        System.out.println("\n=== DADOS CADASTRADOS ===");
        System.out.println("Nome: " + nomeCompleto);
        System.out.println("Idade: " + idade + " anos");
        System.out.printf("Salário: R$ %.2f\n", salario);
        System.out.println("Tem filhos: " + (temFilhos ? "Sim" : "Não"));
        System.out.println("Observações: " + observacoes);

        input.close();
    }
}