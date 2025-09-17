package br.com.senai.Modulo4;

import java.util.Scanner;
import java.util.ArrayList;

public class SistemaGestaoFuncionarios {
    private static ArrayList<String> nomes = new ArrayList<>();
    private static ArrayList<Double> salarios = new ArrayList<>();
    private static ArrayList<String> cargos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    buscarFuncionario();
                    break;
                case 4:
                    calcularEstatisticas();
                    break;
                case 5:
                    aumentarSalarios();
                    break;
                case 6:
                    removerFuncionario();
                    break;
                case 0:
                    System.out.println("Sistema encerrado!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE GESTÃO DE FUNCIONÁRIOS ===");
        System.out.println("1 - Cadastrar Funcionário");
        System.out.println("2 - Listar Funcionários");
        System.out.println("3 - Buscar Funcionário");
        System.out.println("4 - Calcular Estatísticas");
        System.out.println("5 - Aumentar Salários");
        System.out.println("6 - Remover Funcionário");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarFuncionario() {
        System.out.println("\n--- CADASTRO DE FUNCIONÁRIO ---");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();

        System.out.print("Salário: R$ ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer

        nomes.add(nome);
        cargos.add(cargo);
        salarios.add(salario);

        System.out.println("✅ Funcionário cadastrado com sucesso!");
    }

    private static void listarFuncionarios() {
        if (nomes.isEmpty()) {
            System.out.println("❌ Nenhum funcionário cadastrado!");
            return;
        }

        System.out.println("\n--- LISTA DE FUNCIONÁRIOS ---");
        System.out.println("ID | Nome                 | Cargo               | Salário");
        System.out.println("---|----------------------|---------------------|----------");

        for (int i = 0; i < nomes.size(); i++) {
            System.out.printf("%2d | %-20s | %-19s | R$ %8.2f\n",
                    i + 1, nomes.get(i), cargos.get(i), salarios.get(i));
        }
    }

    private static void buscarFuncionario() {
        if (nomes.isEmpty()) {
            System.out.println("❌ Nenhum funcionário cadastrado!");
            return;
        }

        System.out.print("Digite o nome para buscar: ");
        String nomeBusca = scanner.nextLine().toLowerCase();

        System.out.println("\n--- RESULTADOS DA BUSCA ---");
        boolean encontrou = false;

        for (int i = 0; i < nomes.size(); i++) {
            if (nomes.get(i).toLowerCase().contains(nomeBusca)) {
                if (!encontrou) {
                    System.out.println("ID | Nome                 | Cargo               | Salário");
                    System.out.println("---|----------------------|---------------------|----------");
                    encontrou = true;
                }
                System.out.printf("%2d | %-20s | %-19s | R$ %8.2f\n",
                        i + 1, nomes.get(i), cargos.get(i), salarios.get(i));
            }
        }

        if (!encontrou) {
            System.out.println("❌ Nenhum funcionário encontrado!");
        }
    }

    private static void calcularEstatisticas() {
        if (nomes.isEmpty()) {
            System.out.println("❌ Nenhum funcionário cadastrado!");
            return;
        }

        double somaSalarios = 0;
        double maiorSalario = salarios.get(0);
        double menorSalario = salarios.get(0);
        String funcionarioMaiorSalario = nomes.get(0);
        String funcionarioMenorSalario = nomes.get(0);

        for (int i = 0; i < salarios.size(); i++) {
            double salario = salarios.get(i);
            somaSalarios += salario;

            if (salario > maiorSalario) {
                maiorSalario = salario;
                funcionarioMaiorSalario = nomes.get(i);
            }

            if (salario < menorSalario) {
                menorSalario = salario;
                funcionarioMenorSalario = nomes.get(i);
            }
        }

        double mediaSalarial = somaSalarios / salarios.size();

        System.out.println("\n--- ESTATÍSTICAS ---");
        System.out.println("Total de funcionários: " + nomes.size());
        System.out.printf("Média salarial: R$ %.2f\n", mediaSalarial);
        System.out.printf("Maior salário: R$ %.2f - %s\n", maiorSalario, funcionarioMaiorSalario);
        System.out.printf("Menor salário: R$ %.2f - %s\n", menorSalario, funcionarioMenorSalario);
        System.out.printf("Folha de pagamento total: R$ %.2f\n", somaSalarios);
    }

    private static void aumentarSalarios() {
        if (nomes.isEmpty()) {
            System.out.println("❌ Nenhum funcionário cadastrado!");
            return;
        }

        System.out.print("Digite o percentual de aumento (%): ");
        double percentual = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer

        double fatorAumento = 1 + (percentual / 100);

        for (int i = 0; i < salarios.size(); i++) {
            double novoSalario = salarios.get(i) * fatorAumento;
            salarios.set(i, novoSalario);
        }

        System.out.printf("✅ Aumento de %.2f%% aplicado a todos os funcionários!\n", percentual);
    }

    private static void removerFuncionario() {
        if (nomes.isEmpty()) {
            System.out.println("❌ Nenhum funcionário cadastrado!");
            return;
        }

        listarFuncionarios();

        System.out.print("Digite o ID do funcionário para remover: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        if (id >= 1 && id <= nomes.size()) {
            String nomeRemovido = nomes.get(id - 1);
            nomes.remove(id - 1);
            cargos.remove(id - 1);
            salarios.remove(id - 1);

            System.out.println("✅ Funcionário " + nomeRemovido + " removido com sucesso!");
        } else {
            System.out.println("❌ ID inválido!");
        }
    }
}