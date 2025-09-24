package br.com.senai.Modulo2;

public class ExemplosFor {
    public static void main(String[] args) {

        System.out.println("=== TABUADA DO 7 ===");
        for (int i = 1; i <= 10; i++) {
            System.out.println("7 x " + i + " = " + (7 * i));
        }

        System.out.println("\n=== NÚMEROS PARES DE 1 A 20 ===");
        for (int i = 2; i <= 20; i += 2) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n=== CONTAGEM REGRESSIVA ===");
        for (int i = 10; i >= 1; i--) {
            System.out.println(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("🚀 DECOLAGEM!");

        int soma = 0;
        for (int i = 1; i <= 100; i++) {
            soma += i;
        }
        System.out.println("\nSoma de 1 a 100: " + soma);
    }
}