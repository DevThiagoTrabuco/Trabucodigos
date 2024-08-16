package Atividade07;

import java.util.Scanner;

public class Principal {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        System.out.println("Digite o seu nome");
        String nome = new Scanner(System.in).nextLine();
        System.out.println("Informe o número da conta");
        int conta = new Scanner(System.in).nextInt();

        ContaCorrente Conta1 = new ContaCorrente(nome, conta);

        System.out.println(Conta1.getaccOwner());
        System.out.println(Conta1.getaccount());
        System.out.println(Conta1.getbalance());

        System.out.println("Digite o valor de depósito");
        double deposito = new Scanner(System.in).nextDouble();
        Conta1.deposit(deposito);
        System.out.println("Digite o valor do saque");
        double saque = new Scanner(System.in).nextDouble();
        Conta1.withdraw(saque);
        System.out.println(Conta1.getbalance());
    }
}
