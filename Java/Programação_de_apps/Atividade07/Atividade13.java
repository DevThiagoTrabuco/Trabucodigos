package Atividade07;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Atividade13 {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        List<ContaCorrente> Conta = new ArrayList<>();
        boolean quit = false;

        while(!quit){
            System.out.println("""
                               Bem vindo ao BDSM - Banco Dr. São Marinho
                               Escolha uma opção:
                               [1] - Cria Conta
                               [2] - Acessar Conta
                               [3] - Listar Contas
                               [Outro número] - Sair""");
            int op = new Scanner(System.in).nextInt();

            switch (op) {
                case 1 -> {
                    System.out.println("Digite o seu nome:");
                    String name = new Scanner(System.in).nextLine();
                    int nConta = new Random().nextInt(100000, 1000000);
                    String accNumber = String.valueOf(nConta);

                    ContaCorrente account = new ContaCorrente(name, accNumber);
                    Conta.add(account);
                    System.out.println("O número da sua Conta é: " + account.getaccount());
                }
                case 2 -> {
                    String name;
                    if(Conta.isEmpty()){
                        System.out.println("Sem Contas cadastradas.");
                    } else {
                        System.out.println("Digite o seu nome e o número da sua Conta");
                        name = new Scanner(System.in).nextLine();
                        String acc = new Scanner(System.in).nextLine();
                        boolean found = false;

                        for(ContaCorrente conta : Conta){
                            if(conta.getaccOwner().equals(name)
                                    && conta.getaccount().equals(acc)){
                                found = true;
                                boolean quit2 = false;
                                int index = Conta.indexOf(conta);

                                while(!quit2){
                                    System.out.println("Titular: " + Conta.get(index).getaccOwner()
                                            + "\nConta: " + Conta.get(index).getaccount()
                                            + "\nSaldo: " + Conta.get(index).getbalance()
                                            + "\nDigite uma opção:"
                                                    + "\n[1] - Depositar"
                                                    + "\n[2] - Sacar"
                                                    + "\n[Outro número] - Sair da Conta");
                                    int choice = new Scanner(System.in).nextInt();

                                    switch (choice) {
                                        case 1 -> {
                                            System.out.println("Digite o valor do depósito:");
                                            double deposito = new Scanner(System.in).nextDouble();
                                            if(deposito <= 0){
                                                System.out.println("Inpossível realizar depósito.");
                                            } else {
                                                Conta.get(index).deposit(deposito);
                                            }
                                        }
                                        case 2 -> {
                                            System.out.println("Digite o valor do saque:");
                                            double saque = new Scanner(System.in).nextDouble();
                                            if(saque > Conta.get(index).getbalance()){
                                                System.out.println("Saldo insuficiente.");
                                            } else if(saque <= 0){
                                                System.out.println("Impossível realizar saque.");
                                            } else {
                                                Conta.get(index).withdraw(saque);
                                            }
                                        }
                                        default -> quit2 = true;
                                    }
                                }
                                break;
                            }
                        }
                        if(!found){
                            System.out.println("Conta não encontrada.");
                        }
                    }
                }
                case 3 -> {
                    if(Conta.isEmpty()){
                        System.out.println("Sem Contas cadastradas");
                    } else {
                        int i = 1;
                        for(ContaCorrente conta : Conta){
                            System.out.println("["+i+"] " + conta.getaccOwner());
                            System.out.println("Conta: " + conta.getaccount());
                            i++;
                        }
                    }
                }
                default -> quit = true;
            }
        }
    }
}
