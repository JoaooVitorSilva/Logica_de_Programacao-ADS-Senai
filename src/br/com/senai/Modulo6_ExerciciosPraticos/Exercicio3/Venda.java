package br.com.senai.Modulo6_ExerciciosPraticos.Exercicio3;

import java.util.*;

public class Venda {
    private Map<Produto, Integer> itens = new HashMap<>();

    public void adicionar(Produto p, int q) {
        itens.put(p, itens.getOrDefault(p, 0) + q);
    }

    public double total() {
        double t = 0;
        for (var e : itens.entrySet()) {
            t += e.getKey().getPreco() * e.getValue();
        }
        return t;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Venda:\n");
        for (var e : itens.entrySet()) {
            sb.append(e.getKey().getNome())
                    .append(" x").append(e.getValue())
                    .append(" = R$").append(e.getKey().getPreco() * e.getValue())
                    .append("\n");
        }
        sb.append("Total: R$").append(total());
        return sb.toString();
    }
}
