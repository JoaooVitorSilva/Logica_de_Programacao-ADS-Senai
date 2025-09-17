package br.com.senai.Modulo1;

public class OperadoresAritmeticos {
    public static void main(String[] args) {
        int a = 15, b = 4;

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Soma: " + (a + b));        // 19
        System.out.println("Subtração: " + (a - b));   // 11
        System.out.println("Multiplicação: " + (a * b)); // 60
        System.out.println("Divisão: " + (a / b));     // 3 (divisão inteira)
        System.out.println("Resto: " + (a % b));       // 3

        // Divisão com decimais
        double divisaoReal = (double) a / b;
        System.out.printf("Divisão real: %.2f\n", divisaoReal); // 3,75

        // Incremento e decremento
        int contador = 10;
        System.out.println("Contador inicial: " + contador);
        System.out.println("Pré-incremento: " + (++contador)); // 11
        System.out.println("Pós-incremento: " + (contador++)); // 11, depois vira 12
        System.out.println("Contador final: " + contador);     // 12
    }
}