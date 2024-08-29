package Atividade05;

import java.util.Scanner;

public class Principal02 {
    @SuppressWarnings({"resource"})
    public static void main(String[] args) {
        Funcionario[] employee = new Funcionario[3];
        int op = 9, x = -1;
        while(op != 0){
            System.out.println("Bem vindo ao sistema de controle de Funcionários");
            System.out.println("O que deseja fazer?\n[1] - Cadastrar funcionário\n[2] - Listar funcionários\n[3] - Ajustar salários\n[0] - sair");
            op = new Scanner(System.in).nextInt();

            switch (op) {
                case 1:
                x++;
                    if(x < 3){
                        System.out.println("Digite o nome do " + (x + 1) + "º funcionário:");
                        String name = new Scanner(System.in).nextLine();
                        System.out.println("Digite o salário do funcionário:");
                        double salary = new Scanner(System.in).nextDouble();
            
                        employee[x] = new Funcionario(name, salary);
                    } else {
                        System.out.println("Impossível cadastrar mais funcionários");
                    }
                    break;
                case 2:
                    for(int y = 0;y <= x;y++){
                        System.out.println("[" + (y+1) + "] " + employee[y].getname());
                        System.out.println("Salário: " + employee[y].getwage());
                    }
                    break;
                case 3:
                    System.out.println("Escolha um funcionário para ajustar seu salário");
                    for(int y = 0;y <= x;y++){
                        System.out.println("[" + (y+1) + "] " + employee[y].getname());
                        System.out.println("Salário: " + employee[y].getwage());
                    }
                    int j = new Scanner(System.in).nextInt();
                    if(employee[j-1] == null){
                        System.out.println("Funcionário " + j + "não cadastrado");
                    } else {
                        System.out.println("Digite o percentual de aumento de salário do funcionário " + employee[j-1].getname());
                        double percentage = new Scanner(System.in).nextDouble();
                        System.out.println("O novo salário do funcionário é: " + employee[j-1].increaseWage(percentage));
                    }
                    break;
                default:
                    op = 0;
                    break;
            }
        }
    }
}
