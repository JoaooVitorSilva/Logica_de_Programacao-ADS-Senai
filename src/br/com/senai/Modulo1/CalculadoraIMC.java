package br.com.senai.Modulo1;

import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite sua altura (em metros): ");
        double altura = scanner.nextDouble();

        System.out.print("Digite seu peso (em kg): ");
        double peso = scanner.nextDouble();

        double imc = peso / (altura * altura);

        System.out.println("\n--- Resultado ---");
        System.out.println("Nome: " + nome);
        System.out.printf("IMC: %.2f\n", imc);

        scanner.close();
    }
}