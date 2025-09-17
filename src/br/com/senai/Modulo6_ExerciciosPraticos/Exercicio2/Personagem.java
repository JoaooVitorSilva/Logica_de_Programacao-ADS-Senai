package br.com.senai.Modulo6_ExerciciosPraticos.Exercicio2;

public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int ataque;
    protected int defesa;
    protected int nivel = 1;
    protected int xp = 0;

    public Personagem(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public boolean vivo() { return vida > 0; }

    public void receberDano(int dano) {
        int real = Math.max(0, dano - defesa);
        vida -= real;
        if (vida < 0) vida = 0;
    }

    public int atacar() { return ataque; }

    public void ganharXP(int q) {
        xp += q;
        while (xp >= 100) {
            xp -= 100;
            nivel++;
            vida += 10; ataque += 2; defesa += 1;
            System.out.println(nome + " subiu para nível " + nivel);
        }
    }

    @Override
    public String toString() {
        return nome + " (Nv." + nivel + ") HP:" + vida + " ATK:" + ataque + " DEF:" + defesa;
    }
}
