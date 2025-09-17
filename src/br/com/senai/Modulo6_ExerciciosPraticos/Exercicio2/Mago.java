package br.com.senai.Modulo6_ExerciciosPraticos.Exercicio2;

public class Mago extends Personagem {
    private int mana = 50;
    public Mago(String nome) { super(nome, 80, 22, 3); }

    @Override
    public int atacar() {
        if (mana >= 10) { mana -= 10; return ataque + 10; }
        return ataque;
    }
}
