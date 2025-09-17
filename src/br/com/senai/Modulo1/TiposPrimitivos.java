package br.com.senai.Modulo1;

public class TiposPrimitivos {
    public static void main(String[] args) {
        // Números inteiros
        byte idade = 25;           // -128 a 127
        short ano = 2024;          // -32.768 a 32.767
        int populacao = 1000000;   // -2^31 a 2^31-1
        long distancia = 123456789L; // -2^63 a 2^63-1

        // Números decimais
        float altura = 1.75f;      // 32 bits
        double peso = 70.5;        // 64 bits

        // Caractere e booleano
        char inicial = 'A';        // Um único caractere
        boolean ativo = true;      // true ou false

        // String (não é primitivo, mas muito usado)
        String nome = "João Silva";

        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Altura: " + altura + "m");
        System.out.println("Peso: " + peso + "kg");
        System.out.println("Ativo: " + ativo);
    }
}