package br.com.senai.Modulo5.Classes_Objetos_Basicos;


public class Pessoa {

    private String nome;
    private int idade;
    private double altura;
    private String email;


    public Pessoa() {
        this.nome = "";
        this.idade = 0;
        this.altura = 0.0;
        this.email = "";
    }


    public Pessoa(String nome, int idade, double altura, String email) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.email = email;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        } else {
            System.out.println("Nome inválido!");
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade >= 0 && idade <= 120) {
            this.idade = idade;
        } else {
            System.out.println("Idade inválida!");
        }
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura > 0 && altura <= 3.0) {
            this.altura = altura;
        } else {
            System.out.println("Altura inválida!");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Email inválido!");
        }
    }

    public void apresentar() {
        System.out.println("Olá! Meu nome é " + nome);
        System.out.println("Tenho " + idade + " anos e " + altura + "m de altura");
    }

    public boolean ehMaiorDeIdade() {
        return idade >= 18;
    }

    public String getClassificacaoIdade() {
        if (idade <= 12) return "Criança";
        else if (idade <= 17) return "Adolescente";
        else if (idade <= 59) return "Adulto";
        else return "Idoso";
    }

    public double calcularIMC(double peso) {
        if (altura > 0) {
            return peso / (altura * altura);
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Pessoa{nome='%s', idade=%d, altura=%.2f, email='%s'}",
                nome, idade, altura, email);
    }
}