package br.com.senai.Modulo6_ExerciciosPraticos.Exercicio1;

import java.util.*;

public class Biblioteca {
    private Map<String, Livros> livros = new HashMap<>();

    public void cadastrar(Livros b) {
        livros.put(b.getIsbn(), b);
    }

    public boolean emprestar(String isbn) {
        Livros b = livros.get(isbn);
        if (b != null && !b.isEmprestado()) {
            b.setEmprestado(true);
            return true;
        }
        return false;
    }

    public boolean devolver(String isbn) {
        Livros b = livros.get(isbn);
        if (b != null && b.isEmprestado()) {
            b.setEmprestado(false);
            return true;
        }
        return false;
    }

    public Livros consultar(String isbn) {
        return livros.get(isbn);
    }

    public List<Livros> listarPorAutor(String autor) {
        List<Livros> res = new ArrayList<>();
        for (Livros b : livros.values()) {
            if (b.getAutor().equalsIgnoreCase(autor)) res.add(b);
        }
        return res;
    }

    public List<Livros> listarTodos() {
        return new ArrayList<>(livros.values());
    }
}
