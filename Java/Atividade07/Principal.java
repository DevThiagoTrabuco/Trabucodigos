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
        int op = 10;
        while(op != 0){
            System.out.println("Titular da conta: " + Conta1.getaccOwner());
            System.out.println("Conta: " + Conta1.getaccount());
            System.out.println("Saldo: R$" + Conta1.getbalance());
            
            System.out.println("Escolha uma opção");
            System.out.println("[1] - Depositar\n[2] - Sacar\n[0] - Sair");
            op = new Scanner(System.in).nextInt();

            if(op == 1){
                System.out.println("Digite o valor de depósito");
                double deposito = new Scanner(System.in).nextDouble();
                Conta1.deposit(deposito);
            } else if (op == 2 ){
                System.out.println("Digite o valor do saque");
                double saque = new Scanner(System.in).nextDouble();
                if(saque > Conta1.getbalance()){
                    System.out.println("Impossível sacar valor maior que o saldo");
                } else {
                    Conta1.withdraw(saque);
                }
            } else {
                op = 0;
            }
        }
    }
}
