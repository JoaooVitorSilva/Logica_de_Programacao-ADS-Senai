package br.com.senai.Modulo6_ExerciciosPraticos.Exercicio3;

import java.util.*;

public class VendasApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Loja loja = new Loja();

        loja.cadastrar(new Produto("P1", "Caneta", 2.5, 50));
        loja.cadastrar(new Produto("P2", "Caderno", 15.0, 20));

        while (true) {
            System.out.println("\n--- Sistema de Vendas ---");
            System.out.println("1. Listar produtos");
            System.out.println("2. Vender produto");
            System.out.println("3. Relatório de vendas");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            int op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1 -> loja.listarProdutos();
                case 2 -> {
                    System.out.print("Código: "); String c = sc.nextLine();
                    System.out.print("Quantidade: "); int q = Integer.parseInt(sc.nextLine());
                    if (!loja.vender(c, q)) System.out.println("Falha na venda!");
                }
                case 3 -> loja.relatorio();
                case 0 -> { return; }
            }
        }
    }
}
