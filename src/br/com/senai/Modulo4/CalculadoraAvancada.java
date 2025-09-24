package br.com.senai.Modulo4;

public class CalculadoraAvancada {

    public static void main(String[] args) {

        System.out.println("=== CALCULADORA AVANÇADA ===");

        double a = 15.5, b = 4.2;

        System.out.println("Números: " + a + " e " + b);
        System.out.println("Soma: " + somar(a, b));
        System.out.println("Subtração: " + subtrair(a, b));
        System.out.println("Multiplicação: " + multiplicar(a, b));
        System.out.println("Divisão: " + dividir(a, b));
        System.out.println("Potência: " + potencia(a, (int)b));

        System.out.println("\n=== FUNÇÕES MATEMÁTICAS ===");
        System.out.println("Fatorial de 5: " + fatorial(5));
        System.out.println("Fibonacci de 10: " + fibonacci(10));
        System.out.println("15 é primo? " + ehPrimo(15));
        System.out.println("17 é primo? " + ehPrimo(17));

        System.out.println("\n=== VALIDAÇÕES ===");
        System.out.println("15.5 é par? " + ehPar((int)a));
        System.out.println("4.2 é positivo? " + ehPositivo(b));
    }

    public static double somar(double x, double y) {
        return x + y;
    }

    public static double subtrair(double x, double y) {
        return x - y;
    }

    public static double multiplicar(double x, double y) {
        return x * y;
    }

    public static double dividir(double x, double y) {
        if (y == 0) {
            System.out.println("Erro: Divisão por zero!");
            return Double.NaN;
        }
        return x / y;
    }

    public static double potencia(double base, int expoente) {
        double resultado = 1;

        for (int i = 0; i < Math.abs(expoente); i++) {
            resultado *= base;
        }

        return expoente < 0 ? 1 / resultado : resultado;
    }

    public static long fatorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Fatorial não definido para números negativos");
        }
        if (n <= 1) {
            return 1;
        }
        return n * fatorial(n - 1);
    }

    public static long fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static boolean ehPrimo(int numero) {
        if (numero <= 1) return false;
        if (numero <= 3) return true;
        if (numero % 2 == 0 || numero % 3 == 0) return false;

        for (int i = 5; i * i <= numero; i += 6) {
            if (numero % i == 0 || numero % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean ehPar(int numero) {
        return numero % 2 == 0;
    }

    public static boolean ehPositivo(double numero) {
        return numero > 0;
    }

    public static int maximo(int a, int b) {
        return (a > b) ? a : b;
    }

    public static double maximo(double a, double b) {
        return (a > b) ? a : b;
    }

    public static int maximo(int a, int b, int c) {
        return maximo(maximo(a, b), c);
    }
}