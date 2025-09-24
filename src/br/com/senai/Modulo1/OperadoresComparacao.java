package br.com.senai.Modulo1;

public class OperadoresComparacao {
    public static void main(String[] args) {
        int x = 10, y = 20, z = 10;


        System.out.println("x == z: " + (x == z));
        System.out.println("x != y: " + (x != y));
        System.out.println("x < y: " + (x < y));
        System.out.println("y > x: " + (y > x));
        System.out.println("x <= z: " + (x <= z));
        System.out.println("y >= x: " + (y >= x));


        boolean condicao1 = x < y;
        boolean condicao2 = z == x;
        boolean condicao3 = y < x;

        System.out.println("AND (&&): " + (condicao1 && condicao2));
        System.out.println("OR (||): " + (condicao2 || condicao3));
        System.out.println("NOT (!): " + (!condicao3));
    }
}