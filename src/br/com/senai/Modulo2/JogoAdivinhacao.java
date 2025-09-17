package br.com.senai.Modulo2;

import java.util.Scanner;
import java.util.Random;

public class JogoAdivinhacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroSecreto = random.nextInt(100) + 1; // 1 a 100
        int tentativa = 0;
        int numeroTentativas = 0;
        boolean acertou = false;

        System.out.println("=== JOGO DA ADIVINHAÇÃO ===");
        System.out.println("Pensei em um número de 1 a 100!");
        System.out.println("Tente adivinhar!\n");

        while (!acertou && numeroTentativas < 10) {
            System.out.print("Digite sua tentativa: ");
            tentativa = scanner.nextInt();
            numeroTentativas++;

            if (tentativa == numeroSecreto) {
                acertou = true;
                System.out.println("🎉 PARABÉNS! Você acertou!");
                System.out.println("Número de tentativas: " + numeroTentativas);
            } else if (tentativa < numeroSecreto) {
                System.out.println("📈 Muito baixo! Tente um número maior.");
            } else {
                System.out.println("📉 Muito alto! Tente um número menor.");
            }

            if (!acertou && numeroTentativas < 10) {
                System.out.println("Tentativas restantes: " + (10 - numeroTentativas) + "\n");
            }
        }

        if (!acertou) {
            System.out.println("\n😔 Suas tentativas acabaram!");
            System.out.println("O número era: " + numeroSecreto);
        }

        scanner.close();
    }
}