package br.com.senai.Modulo5.Classes_Objetos_Basicos;


public class TestePessoa {
    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Maria Silva");
        pessoa1.setIdade(25);
        pessoa1.setAltura(1.65);
        pessoa1.setEmail("maria@email.com");

        Pessoa pessoa2 = new Pessoa("João Santos", 30, 1.80, "joao@email.com");

        System.out.println("=== PESSOA 1 ===");
        pessoa1.apresentar();
        System.out.println("Maior de idade? " + (pessoa1.ehMaiorDeIdade() ? "Sim" : "Não"));
        System.out.println("Classificação: " + pessoa1.getClassificacaoIdade());
        System.out.printf("IMC (peso 60kg): %.2f\n", pessoa1.calcularIMC(60));
        System.out.println(pessoa1.toString());

        System.out.println("\n=== PESSOA 2 ===");
        pessoa2.apresentar();
        System.out.println("Maior de idade? " + (pessoa2.ehMaiorDeIdade() ? "Sim" : "Não"));
        System.out.println("Classificação: " + pessoa2.getClassificacaoIdade());
        System.out.printf("IMC (peso 75kg): %.2f\n", pessoa2.calcularIMC(75));
        System.out.println(pessoa2.toString());
    }
}