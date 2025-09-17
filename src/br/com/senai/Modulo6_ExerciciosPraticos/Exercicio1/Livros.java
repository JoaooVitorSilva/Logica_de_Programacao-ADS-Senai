package br.com.senai.Modulo6_ExerciciosPraticos.Exercicio1;

public class Livros {
    private String titulo;
    private String autor;
    private String isbn;
    private int ano;
    private boolean emprestado;

    public Livros(String titulo, String autor, String isbn, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.ano = ano;
        this.emprestado = false;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }
    public int getAno() { return ano; }
    public boolean isEmprestado() { return emprestado; }
    public void setEmprestado(boolean emprestado) { this.emprestado = emprestado; }

    @Override
    public String toString() {
        return String.format("%s — %s (ISBN: %s, %d) %s",
                titulo, autor, isbn, ano, emprestado ? "[EMPRESTADO]":"[DISPONÍVEL]");
    }
}
