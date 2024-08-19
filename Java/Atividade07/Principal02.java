/*Usando a classe ContaCorrente feita na ultima atividade: 
Crie uma classe separada e dentro dela faça o método main
Crie um array(vetor) de capaz de armazenar 3 contas
Usando println e scanner permita ao usuário:
Criar uma conta
Logar em uma das contas existentes
Uma vez logado permita ao usuário realizar depósitos, saques ou deslogar. */
package Atividade07;

import java.util.Random;
import java.util.Scanner;

public class Principal02 {
    public static void main(String[] args) {
        ContaCorrente[] conta = new ContaCorrente[3];
        int op = 9, x = 0;

        while(op != 0){
            System.out.println("Bem vindo ao BDSM - Banco Dr. São Marinho");
            System.out.println("O que deseja fazer?\n[1] - Criar conta\n[2] - Entrar numa conta\n[0] - Sair");
            op = new Scanner(System.in).nextInt();

            switch (op) {
                case 1:
                    System.out.println("Digite o seu nome");
                    String nome = new Scanner(System.in).nextLine();
                    int nConta = new Random().nextInt(100000, 1000000);
                    String accNumber = String.valueOf(nConta);

                    conta[x] = new ContaCorrente(nome, accNumber);
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }
    }
}
