package br.com.senai.Modulo6_ExerciciosPraticos.Exercicio2;

import java.util.*;

public class RpgApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Seu nome: "); String nome = sc.nextLine();
        System.out.print("Classe (1=Guerreiro 2=Mago 3=Arqueiro): ");
        int op = Integer.parseInt(sc.nextLine());

        Personagem jogador = switch (op) {
            case 1 -> new Guerreiro(nome);
            case 2 -> new Mago(nome);
            default -> new Arqueiro(nome);
        };

        Personagem inimigo = new Guerreiro("Goblin");
        System.out.println("Batalha: " + jogador + " vs " + inimigo);

        while (jogador.vivo() && inimigo.vivo()) {
            inimigo.receberDano(jogador.atacar());
            if (!inimigo.vivo()) break;
            jogador.receberDano(inimigo.atacar());
            System.out.println(jogador);
            System.out.println(inimigo);
        }

        if (jogador.vivo()) {
            System.out.println("Você venceu!");
            jogador.ganharXP(120);
        } else {
            System.out.println("Você foi derrotado...");
        }
    }
}
