package br.com.senai.Modulo1;

public class TiposPrimitivos {
    public static void main(String[] args) {

        byte idade = 25;
        short ano = 2024;
        int populacao = 1000000;
        long distancia = 123456789L;

        float altura = 1.75f;
        double peso = 70.5;

        char inicial = 'A';
        boolean ativo = true;

        String nome = "João Silva";

        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Altura: " + altura + "m");
        System.out.println("Peso: " + peso + "kg");
        System.out.println("Ativo: " + ativo);
    }
}