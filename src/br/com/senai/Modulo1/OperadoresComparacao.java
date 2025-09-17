package br.com.senai.Modulo1;

public class OperadoresComparacao {
    public static void main(String[] args) {
        int x = 10, y = 20, z = 10;

        // Operadores de comparação
        System.out.println("x == z: " + (x == z)); // true
        System.out.println("x != y: " + (x != y)); // true
        System.out.println("x < y: " + (x < y));   // true
        System.out.println("y > x: " + (y > x));   // true
        System.out.println("x <= z: " + (x <= z)); // true
        System.out.println("y >= x: " + (y >= x)); // true

        // Operadores lógicos
        boolean condicao1 = x < y;  // true
        boolean condicao2 = z == x; // true
        boolean condicao3 = y < x;  // false

        System.out.println("AND (&&): " + (condicao1 && condicao2)); // true
        System.out.println("OR (||): " + (condicao2 || condicao3));  // true
        System.out.println("NOT (!): " + (!condicao3));              // true
    }
}