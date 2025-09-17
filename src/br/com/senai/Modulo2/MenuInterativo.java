package br.com.senai.Modulo2;

import java.util.Scanner;

public class MenuInterativo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        double saldo = 1000.0;

        System.out.println("=== BANCO DIGITAL ===");

        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.printf("Seu saldo atual: R$ %.2f\n", saldo);
                    break;

                case 2:
                    System.out.print("Digite o valor para depósito: R$ ");
                    double valorDeposito = scanner.nextDouble();
                    if (valorDeposito > 0) {
                        saldo += valorDeposito;
                        System.out.printf("Depósito realizado! Novo saldo: R$ %.2f\n", saldo);
                    } else {
                        System.out.println("Valor inválido!");
                    }
                    break;

                case 3:
                    System.out.print("Digite o valor para saque: R$ ");
                    double valorSaque = scanner.nextDouble();
                    if (valorSaque > 0 && valorSaque <= saldo) {
                        saldo -= valorSaque;
                        System.out.printf("Saque realizado! Novo saldo: R$ %.2f\n", saldo);
                    } else if (valorSaque > saldo) {
                        System.out.println("Saldo insuficiente!");
                    } else {
                        System.out.println("Valor inválido!");
                    }
                    break;

                case 4:
                    System.out.print("Digite o valor para transferência: R$ ");
                    double valorTransferencia = scanner.nextDouble();
                    if (valorTransferencia > 0 && valorTransferencia <= saldo) {
                        saldo -= valorTransferencia;
                        System.out.printf("Transferência realizada! Novo saldo: R$ %.2f\n", saldo);
                    } else if (valorTransferencia > saldo) {
                        System.out.println("Saldo insuficiente!");
                    } else {
                        System.out.println("Valor inválido!");
                    }
                    break;

                case 0:
                    System.out.println("Obrigado por usar nosso banco! Até logo! 👋");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}