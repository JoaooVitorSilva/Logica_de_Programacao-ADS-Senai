package br.com.senai.Modulo3;

import java.util.Scanner;
import java.util.Random;

public class JogoDaVelha {
    private static char[][] tabuleiro = new char[3][3];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarTabuleiro();

        System.out.println("=== JOGO DA VELHA ===");
        System.out.println("Jogador X vs Jogador O");
        System.out.println("Digite a posição como: linha coluna (1-3)");

        char jogadorAtual = 'X';
        boolean jogoAtivo = true;
        int jogadas = 0;

        while (jogoAtivo && jogadas < 9) {
            mostrarTabuleiro();

            System.out.println("\nJogador " + jogadorAtual + ", é sua vez!");
            System.out.print("Digite a posição (linha coluna): ");

            int linha = scanner.nextInt() - 1;
            int coluna = scanner.nextInt() - 1;

            if (posicaoValida(linha, coluna)) {
                tabuleiro[linha][coluna] = jogadorAtual;
                jogadas++;

                if (verificarVitoria(jogadorAtual)) {
                    mostrarTabuleiro();
                    System.out.println("\n🎉 JOGADOR " + jogadorAtual + " VENCEU!");
                    jogoAtivo = false;
                } else if (jogadas == 9) {
                    mostrarTabuleiro();
                    System.out.println("\n🤝 EMPATE!");
                    jogoAtivo = false;
                } else {
                    jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Posição inválida ou já ocupada! Tente novamente.");
            }
        }

        scanner.close();
    }

    private static void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    private static void mostrarTabuleiro() {
        System.out.println("\n   1   2   3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + "  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----------");
        }
    }

    private static boolean posicaoValida(int linha, int coluna) {
        return linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 &&
                tabuleiro[linha][coluna] == ' ';
    }

    private static boolean verificarVitoria(char jogador) {
        // Verificar linhas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
                return true;
            }
        }

        // Verificar colunas
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] == jogador && tabuleiro[1][j] == jogador && tabuleiro[2][j] == jogador) {
                return true;
            }
        }

        // Verificar diagonais
        if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
            return true;
        }

        if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) {
            return true;
        }

        return false;
    }
}
