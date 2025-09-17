package br.com.senai.Modulo2;

import java.util.Scanner;

public class MenuCalculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CALCULADORA ===");
        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();

        System.out.println("\nEscolha a operação:");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.println("5 - Potência");
        System.out.print("Opção: ");

        int opcao = scanner.nextInt();
        double resultado = 0;
        boolean operacaoValida = true;

        switch (opcao) {
            case 1:
                resultado = num1 + num2;
                System.out.printf("%.2f + %.2f = %.2f\n", num1, num2, resultado);
                break;

            case 2:
                resultado = num1 - num2;
                System.out.printf("%.2f - %.2f = %.2f\n", num1, num2, resultado);
                break;

            case 3:
                resultado = num1 * num2;
                System.out.printf("%.2f × %.2f = %.2f\n", num1, num2, resultado);
                break;

            case 4:
                if (num2 != 0) {
                    resultado = num1 / num2;
                    System.out.printf("%.2f ÷ %.2f = %.2f\n", num1, num2, resultado);
                } else {
                    System.out.println("Erro: Divisão por zero!");
                    operacaoValida = false;
                }
                break;

            case 5:
                resultado = Math.pow(num1, num2);
                System.out.printf("%.2f ^ %.2f = %.2f\n", num1, num2, resultado);
                break;

            default:
                System.out.println("Opção inválida!");
                operacaoValida = false;
        }

        if (operacaoValida && opcao != 4) {
            System.out.println("Operação realizada com sucesso!");
        }

        scanner.close();
    }
}