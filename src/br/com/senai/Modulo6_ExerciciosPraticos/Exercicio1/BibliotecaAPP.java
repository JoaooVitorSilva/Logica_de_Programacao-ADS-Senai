package br.com.senai.Modulo6_ExerciciosPraticos.Exercicio1;

import java.util.*;

public class BibliotecaAPP {
    private static Scanner sc = new Scanner(System.in);
    private static Biblioteca lib = new Biblioteca();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Biblioteca ---");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Emprestar livro");
            System.out.println("3. Devolver livro");
            System.out.println("4. Consultar livro");
            System.out.println("5. Listar por autor");
            System.out.println("6. Listar todos");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            int op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1 -> cadastrar();
                case 2 -> emprestar();
                case 3 -> devolver();
                case 4 -> consultar();
                case 5 -> listarAutor();
                case 6 -> listarTodos();
                case 0 -> { System.out.println("Saindo..."); return; }
            }
        }
    }

    private static void cadastrar() {
        System.out.print("Título: "); String t = sc.nextLine();
        System.out.print("Autor: "); String a = sc.nextLine();
        System.out.print("ISBN: "); String i = sc.nextLine();
        System.out.print("Ano: "); int ano = Integer.parseInt(sc.nextLine());
        lib.cadastrar(new Livros(t, a, i, ano));
    }

    private static void emprestar() {
        System.out.print("ISBN: "); String i = sc.nextLine();
        System.out.println(lib.emprestar(i) ? "Emprestado!" : "Não disponível.");
    }

    private static void devolver() {
        System.out.print("ISBN: "); String i = sc.nextLine();
        System.out.println(lib.devolver(i) ? "Devolvido!" : "Falha na devolução.");
    }

    private static void consultar() {
        System.out.print("ISBN: "); String i = sc.nextLine();
        Livros b = lib.consultar(i);
        System.out.println(b != null ? b : "Não encontrado.");
    }

    private static void listarAutor() {
        System.out.print("Autor: "); String a = sc.nextLine();
        for (Livros b : lib.listarPorAutor(a)) System.out.println(b);
    }

    private static void listarTodos() {
        for (Livros b : lib.listarTodos()) System.out.println(b);
    }
}
