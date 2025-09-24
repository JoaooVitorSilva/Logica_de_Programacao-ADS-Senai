package br.com.senai.Modulo6_ExerciciosPraticos.Exercicio2;

public class Arqueiro extends Personagem {
    public Arqueiro(String nome) { super(nome, 90, 16, 4); }

    @Override
    public int atacar() {
        if (Math.random() < 0.25) return ataque * 2;
        return ataque;
    }
}
