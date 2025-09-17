package br.com.senai.Modulo6_ExerciciosPraticos.Exercicio3;

public class Produto {
    private String codigo;
    private String nome;
    private double preco;
    private int estoque;

    public Produto(String codigo, String nome, double preco, int estoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getEstoque() { return estoque; }

    public boolean retirar(int q) {
        if (q <= estoque) { estoque -= q; return true; }
        return false;
    }

    @Override
    public String toString() {
        return codigo + " - " + nome + " (R$" + preco + ") Estoque:" + estoque;
    }
}
