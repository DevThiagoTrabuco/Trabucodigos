package Atividade07;

import java.util.Random;
import java.util.Scanner;

public class Principal02 {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ContaCorrente[] conta = new ContaCorrente[3];
        int op = 9, x = 0;

        while(op != 0){
            System.out.println("Bem vindo ao BDSM - Banco Dr. São Marinho");
            System.out.println("O que deseja fazer?\n[1] - Criar conta\n[2] - Acessar conta\n[0] - Sair do banco");
            op = new Scanner(System.in).nextInt();

            switch (op) {
                case 1:
                    if (x < 3){
                        System.out.println("Digite o seu nome");
                        String nome = new Scanner(System.in).nextLine();
                        int nConta = new Random().nextInt(100000, 1000000);
                        String accNumber = String.valueOf(nConta);

                        conta[x] = new ContaCorrente(nome, accNumber);
                        if(x < 2){
                            x++;
                        }
                    } else {
                        System.out.println("Impossível cadastrar mais contas");
                    }
                    break;
                case 2:
                    System.out.println("Escolha em qual conta deseja entrar:");
                    for(int i = 0; i <= x;i++){
                        System.out.println("[" + (i+1) + "] - " + conta[i].getaccOwner());
                        System.out.println("Conta: " + conta[i].getaccount());
                    }
                    int choice = new Scanner(System.in).nextInt();

                    if((choice == 1 || choice == 2 || choice == 3) && conta[choice-1] != null){
                        int escolha = 9;
                        while (escolha != 0) {
                            System.out.println("Titular da conta: " + conta[choice-1].getaccOwner());
                            System.out.println("Conta: " + conta[choice-1].getaccount());
                            System.out.println("Saldo: R$" + conta[choice-1].getbalance());
                            
                            System.out.println("Escolha uma opção");
                            System.out.println("[1] - Depositar\n[2] - Sacar\n[0] - Sair da conta");
                            escolha = new Scanner(System.in).nextInt();

                            switch (escolha) {
                                case 1:
                                    System.out.println("Digite o valor de depósito");
                                    double deposito = new Scanner(System.in).nextDouble();
                                    if (deposito <= 0){
                                        System.out.println("Impossível realizar depósito");
                                    } else {
                                        conta[choice-1].deposit(deposito);
                                    }
                                break;
                                case 2:
                                    System.out.println("Digite o valor do saque");
                                    double saque = new Scanner(System.in).nextDouble();
                                    if(saque > conta[choice-1].getbalance()){
                                        System.out.println("Saldo insuficiente");
                                    } else if(saque <= 0){
                                        System.out.println("Impossível realizar saque");
                                    }
                                    else {
                                        conta[choice-1].withdraw(saque);
                                    }
                                break;
                                default:
                                    escolha = 0;
                                break;
                            }
                        }
                    } else {
                        System.out.println("Conta não cadastrada");
                    }
                    break;
                default:
                    op = 0;
                    break;
            }
        }
    }
}
