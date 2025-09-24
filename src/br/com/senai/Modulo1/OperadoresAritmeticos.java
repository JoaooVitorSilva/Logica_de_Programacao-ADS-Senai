package br.com.senai.Modulo1;

public class OperadoresAritmeticos {
    public static void main(String[] args) {
        int a = 15, b = 4;

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Soma: " + (a + b));
        System.out.println("Subtração: " + (a - b));
        System.out.println("Multiplicação: " + (a * b));
        System.out.println("Divisão: " + (a / b));
        System.out.println("Resto: " + (a % b));

        double divisaoReal = (double) a / b;
        System.out.printf("Divisão real: %.2f\n", divisaoReal);

        int contador = 10;
        System.out.println("Contador inicial: " + contador);
        System.out.println("Pré-incremento: " + (++contador));
        System.out.println("Pós-incremento: " + (contador++));
        System.out.println("Contador final: " + contador);
    }
}