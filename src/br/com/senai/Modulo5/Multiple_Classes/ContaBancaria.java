package br.com.senai.Modulo5.Multiple_Classes;


public class ContaBancaria {
    private String numeroConta;
    private String titular;
    private double saldo;
    private String tipoConta;
    private static int proximoNumero = 1000;

    public ContaBancaria(String titular, String tipoConta, double depositoInicial) {
        this.numeroConta = String.valueOf(proximoNumero++);
        this.titular = titular;
        this.tipoConta = tipoConta;
        this.saldo = depositoInicial;
    }

    public String getNumeroConta() { return numeroConta; }
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }
    public String getTipoConta() { return tipoConta; }

    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$ %.2f realizado com sucesso!\n", valor);
            return true;
        } else {
            System.out.println("Valor de depósito inválido!");
            return false;
        }
    }

    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido!");
            return false;
        }

        double limite = tipoConta.equals("Poupança") ? saldo : saldo + 500; // Cheque especial

        if (valor <= limite) {
            saldo -= valor;
            System.out.printf("Saque de R$ %.2f realizado com sucesso!\n", valor);
            return true;
        } else {
            System.out.println("Saldo insuficiente!");
            return false;
        }
    }

    public boolean transferir(ContaBancaria contaDestino, double valor) {
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
            System.out.printf("Transferência de R$ %.2f para conta %s realizada!\n",
                    valor, contaDestino.getNumeroConta());
            return true;
        }
        return false;
    }

    public void consultarSaldo() {
        System.out.println("\n--- EXTRATO ---");
        System.out.println("Conta: " + numeroConta);
        System.out.println("Titular: " + titular);
        System.out.println("Tipo: " + tipoConta);
        System.out.printf("Saldo atual: R$ %.2f\n", saldo);

        if (saldo < 0) {
            System.out.println("⚠️  CONTA COM SALDO NEGATIVO!");
        }
    }

    @Override
    public String toString() {
        return String.format("Conta %s - %s (R$ %.2f)", numeroConta, titular, saldo);
    }
}