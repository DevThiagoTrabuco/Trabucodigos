package Atividade07;

import java.util.Random;
import java.util.Scanner;

public class Atividade11 {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ContaCorrente[] conta = new ContaCorrente[3];
        boolean quit = false;
        while(!quit){
            boolean empty = true;
            for(int i = 0; i < conta.length;i++){
                if(conta[i] != null){
                    empty = false;
                }
            }
            System.out.println("Bem vindo ao BDSM - Banco Dr. São Marinho");
            System.out.println("O que deseja fazer?"
            + "\n[1] - Criar conta"
            + "\n[2] - Acessar conta"
            + "\n[3] - Listar contas"
            + "\n[0] - Sair do banco");
            int op = new Scanner(System.in).nextInt();

            switch (op) {
                case 1:
                    System.out.println("Digite o seu nome");
                    String nome = new Scanner(System.in).nextLine();
                    int nConta = new Random().nextInt(100000, 1000000);
                    String accNumber = String.valueOf(nConta);

                    ContaCorrente account = new ContaCorrente(nome, accNumber);
                    boolean full = true;
                    for(int i = 0; i < conta.length;i++){
                        if(conta[i] == null){
                            full = false;
                            conta[i] = account;
                            System.out.println("Número da conta: " + accNumber);
                            break;
                        }
                    }
                    if(full){
                        System.out.println("Impossível cadastrar mais contas");
                    }
                    break;
                case 2:
                    if(!empty){
                        System.out.println("Digite o nome do titular da conta");
                        nome = new Scanner(System.in).nextLine();
                        System.out.println("Digite o número da conta");
                        accNumber = new Scanner(System.in).nextLine();
                        boolean found = false;
                        for(int i = 0; i < conta.length;i++){
                            if(conta[i].getaccOwner().equals(nome)
                                && conta[i].getaccount().equals(accNumber)){
                                found = true;
                                boolean quit2 = false;
                                while(!quit2){
                                    System.out.println("Titular da conta: " + conta[i].getaccOwner());
                                    System.out.println("Conta: " + conta[i].getaccount());
                                    System.out.println("Saldo: R$" + conta[i].getbalance());
                                    System.out.println("\n[1] - Depositar"
                                    + "\n[2] - Sacar"
                                    + "\n[3] - Sair da conta");
                                    int op2 = new Scanner(System.in).nextInt();

                                    if(op2 == 1){
                                        System.out.println("Digite o valor de depósito");
                                        double deposito = new Scanner(System.in).nextDouble();
                                        if (deposito <= 0){
                                            System.out.println("Impossível realizar depósito");
                                        } else {
                                            conta[i].deposit(deposito);
                                        }
                                    } else if (op2 == 2){
                                        System.out.println("Digite o valor do saque");
                                        double saque = new Scanner(System.in).nextDouble();
                                        if(saque > conta[i].getbalance()){
                                            System.out.println("Saldo insuficiente");
                                        } else if(saque <= 0){
                                            System.out.println("Impossível realizar saque");
                                        } else {
                                            conta[i].withdraw(saque);
                                        }
                                    } else {
                                        quit2 = true;
                                    }
                                }
                                break;
                            }
                        }
                        if(!found){
                            System.out.println("Conta não encontrada.");
                        }
                    } else {
                        System.out.println("Sem contas cadastradas");
                    }
                    break;
                case 3:
                if(!empty){
                    for(int i = 0; i < conta.length; i++){
                        for(int j = 1; j < conta.length;j++){
                            System.out.println("["+j+"] - " + conta[i].getaccOwner());
                            System.out.println("["+j+"] - " + conta[i].getaccount());
                        }
                    }
                } else {
                    System.out.println("Sem contas cadstradas.");
                }
                    break;
                default:
                    break;    
            }
        }
    }
}