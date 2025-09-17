package br.com.senai.Modulo6_ExerciciosPraticos.Exercicio3;

import java.util.*;

public class Loja {
    private Map<String, Produto> produtos = new HashMap<>();
    private List<Venda> vendas = new ArrayList<>();

    public void cadastrar(Produto p) { produtos.put(p.getCodigo(), p); }
    public Produto buscar(String c) { return produtos.get(c); }

    public boolean vender(String codigo, int q) {
        Produto p = produtos.get(codigo);
        if (p == null || !p.retirar(q)) return false;
        Venda v = new Venda();
        v.adicionar(p, q);
        vendas.add(v);
        System.out.println("Venda realizada:\n" + v);
        return true;
    }

    public void listarProdutos() {
        for (Produto p : produtos.values()) System.out.println(p);
    }

    public void relatorio() {
        for (Venda v : vendas) System.out.println(v + "\n");
    }
}
