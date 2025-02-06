package Atividade07;

import java.util.Random;
import java.util.Scanner;

public class Principal {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        System.out.println("Bem vindo ao BDSM - Banco Dr. São Marinho\nDigite o seu nome");
        String nome = new Scanner(System.in).nextLine();
        int nConta = new Random().nextInt(100000, 1000000);
        String accNumber = String.valueOf(nConta);

        ContaCorrente Conta1 = new ContaCorrente(nome, accNumber);
        int op = 10;
        while(op != 0){
            System.out.println("Titular da conta: " + Conta1.getaccOwner());
            System.out.println("Conta: " + Conta1.getaccount());
            System.out.println("Saldo: R$" + Conta1.getbalance());
            
            System.out.println("Escolha uma opção");
            System.out.println("[1] - Depositar\n[2] - Sacar\n[0] - Sair");
            op = new Scanner(System.in).nextInt();

            switch (op) {
                case 1:
                    System.out.println("Digite o valor de depósito");
                    double deposito = new Scanner(System.in).nextDouble();
                    if (deposito <= 0){
                        System.out.println("Impossível realizar depósito");
                    } else {
                        Conta1.deposit(deposito);
                    }    
                    break;
                case 2:
                    System.out.println("Digite o valor do saque");
                    double saque = new Scanner(System.in).nextDouble();
                    if(saque > Conta1.getbalance()){
                        System.out.println("Saldo insuficiente");
                    } else if(saque <= 0){
                        System.out.println("Impossível realizar saque");
                    }
                    else {
                        Conta1.withdraw(saque);
                    }
                    break;
                default:
                    op = 0;
                    break;
            }
        }
    }
}
