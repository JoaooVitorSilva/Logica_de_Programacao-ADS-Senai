package br.com.senai.Modulo2;

import java.util.Scanner;

public class ClassificacaoIdade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        if (idade < 0) {
            System.out.println("Idade inválida!");
        } else if (idade <= 12) {
            System.out.println("Criança");
        } else if (idade <= 17) {
            System.out.println("Adolescente");
        } else if (idade <= 59) {
            System.out.println("Adulto");
        } else {
            System.out.println("Idoso");
        }

        scanner.close();
    }
}