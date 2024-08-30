package Atividade05;

import java.util.Scanner;

public class Atividade12 {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Funcionario[] employee = new Funcionario[3];
        boolean quit = false;
        while(!quit){
            System.out.println("Bem vindo ao sistema de controle de Funcionários");
            System.out.println("O que deseja fazer?"
            + "\n[1] - Cadastrar funcionário"
            + "\n[2] - Listar funcionários"
            + "\n[3] - Remover funcionário"
            + "\n[0] - Sair");
            int op = new Scanner(System.in).nextInt();
        }
    }
}
