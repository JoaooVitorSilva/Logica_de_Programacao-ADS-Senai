package br.com.senai.Modulo5.Multiple_Classes;

// Classe principal do sistema bancário

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaBancario {
    private static ArrayList<ContaBancaria> contas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Criar algumas contas para demonstração
        contas.add(new ContaBancaria("Ana Costa", "Corrente", 1000.0));
        contas.add(new ContaBancaria("Carlos Silva", "Poupança", 2500.0));
        contas.add(new ContaBancaria("Beatriz Lima", "Corrente", 500.0));

        int opcao;

        do {
            mostrarMenuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    listarContas();
                    break;
                case 3:
                    realizarDeposito();
                    break;
                case 4:
                    realizarSaque();
                    break;
                case 5:
                    realizarTransferencia();
                    break;
                case 6:
                    consultarExtrato();
                    break;
                case 7:
                    relatorioGeral();
                    break;
                case 0:
                    System.out.println("Obrigado por usar nosso sistema bancário!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n🏦 === SISTEMA BANCÁRIO ===");
        System.out.println("1 - Criar Nova Conta");
        System.out.println("2 - Listar Contas");
        System.out.println("3 - Depositar");
        System.out.println("4 - Sacar");
        System.out.println("5 - Transferir");
        System.out.println("6 - Consultar Extrato");
        System.out.println("7 - Relatório Geral");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void criarConta() {
        System.out.println("\n--- CRIAR NOVA CONTA ---");

        System.out.print("Nome do titular: ");
        String titular = scanner.nextLine();

        System.out.print("Tipo de conta (Corrente/Poupança): ");
        String tipo = scanner.nextLine();

        System.out.print("Depósito inicial: R$ ");
        double deposito = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer

        ContaBancaria novaConta = new ContaBancaria(titular, tipo, deposito);
        contas.add(novaConta);

        System.out.println("✅ Conta criada com sucesso!");
        System.out.println("Número da conta: " + novaConta.getNumeroConta());
    }

    private static void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("❌ Nenhuma conta cadastrada!");
            return;
        }

        System.out.println("\n--- LISTA DE CONTAS ---");
        for (int i = 0; i < contas.size(); i++) {
            System.out.println((i + 1) + ". " + contas.get(i));
        }
    }

    private static ContaBancaria selecionarConta() {
        listarContas();

        if (contas.isEmpty()) return null;

        System.out.print("Selecione o número da conta: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpar buffer

        if (indice >= 0 && indice < contas.size()) {
            return contas.get(indice);
        } else {
            System.out.println("❌ Conta inválida!");
            return null;
        }
    }

    private static void realizarDeposito() {
        System.out.println("\n--- DEPÓSITO ---");
        ContaBancaria conta = selecionarConta();

        if (conta != null) {
            System.out.print("Valor do depósito: R$ ");
            double valor = scanner.nextDouble();
            scanner.nextLine(); // Limpar buffer

            conta.depositar(valor);
        }
    }

    private static void realizarSaque() {
        System.out.println("\n--- SAQUE ---");
        ContaBancaria conta = selecionarConta();

        if (conta != null) {
            System.out.print("Valor do saque: R$ ");
            double valor = scanner.nextDouble();
            scanner.nextLine(); // Limpar buffer

            conta.sacar(valor);
        }
    }

    private static void realizarTransferencia() {
        System.out.println("\n--- TRANSFERÊNCIA ---");
        System.out.println("Conta de origem:");
        ContaBancaria contaOrigem = selecionarConta();

        if (contaOrigem != null) {
            System.out.println("Conta de destino:");
            ContaBancaria contaDestino = selecionarConta();

            if (contaDestino != null && contaDestino != contaOrigem) {
                System.out.print("Valor da transferência: R$ ");
                double valor = scanner.nextDouble();
                scanner.nextLine(); // Limpar buffer

                contaOrigem.transferir(contaDestino, valor);
            } else if (contaDestino == contaOrigem) {
                System.out.println("❌ Não é possível transferir para a mesma conta!");
            }
        }
    }

    private static void consultarExtrato() {
        System.out.println("\n--- EXTRATO ---");
        ContaBancaria conta = selecionarConta();

        if (conta != null) {
            conta.consultarSaldo();
        }
    }

    private static void relatorioGeral() {
        if (contas.isEmpty()) {
            System.out.println("❌ Nenhuma conta cadastrada!");
            return;
        }

        System.out.println("\n--- RELATÓRIO GERAL ---");

        double saldoTotal = 0;
        int contasCorrente = 0, contasPoupanca = 0;
        int contasPositivas = 0, contasNegativas = 0;

        for (ContaBancaria conta : contas) {
            saldoTotal += conta.getSaldo();

            if (conta.getTipoConta().equals("Corrente")) {
                contasCorrente++;
            } else {
                contasPoupanca++;
            }

            if (conta.getSaldo() >= 0) {
                contasPositivas++;
            } else {
                contasNegativas++;
            }
        }

        System.out.println("Total de contas: " + contas.size());
        System.out.println("Contas correntes: " + contasCorrente);
        System.out.println("Contas poupança: " + contasPoupanca);
        System.out.println("Contas com saldo positivo: " + contasPositivas);
        System.out.println("Contas com saldo negativo: " + contasNegativas);
        System.out.printf("Saldo total do banco: R$ %.2f\n", saldoTotal);
        System.out.printf("Média de saldo por conta: R$ %.2f\n", saldoTotal / contas.size());
    }
}