package Atividade08;

import java.util.Random;
import java.util.Scanner;

public class Principal {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        System.out.println("Digite o seu nome");
        String nome = new Scanner(System.in).nextLine();
        int nConta = new Random().nextInt(100000, 1000000);
        String conta = String.valueOf(nConta);

        Scanner scanner = new Scanner(System.in);
        ContaInvestimento Conta1 = new ContaInvestimento(nome, conta, 10);
        int op = 10;
        int time = 0, period = 0;

        while(op != 0){
            System.out.println("Titular da conta: " + Conta1.getaccOwner());
            System.out.println("Conta: " + Conta1.getaccNumber());
            System.out.println("Taxa de juros ao mês: " + Conta1.getinterestRate());
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
                    System.out.println("Por quantos meses o saldo ficará rendendo?");
                    period = new Scanner(System.in).nextInt();
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
        while(time <= period){ 
            System.out.println("Mês: " + time);
            System.out.println("Titular da conta: " + Conta1.getaccOwner());
            System.out.println("Conta: " + Conta1.getaccNumber());
            System.out.println("Taxa de juros ao mês: " + Conta1.getinterestRate());
            System.out.println("Saldo: R$" + Conta1.getbalance());
            Conta1.addInterest(10);
            scanner.nextLine();
            time++;
        }
    }
}
