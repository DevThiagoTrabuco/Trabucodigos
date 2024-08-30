package Atividade05;

import java.util.Scanner;

public class Atividade10 {
    @SuppressWarnings({"resource"})
    public static void main(String[] args) {
        Funcionario[] employee = new Funcionario[3];
        boolean quit = false;
        while(!quit){
            System.out.println("Bem vindo ao sistema de controle de Funcionários");
            System.out.println("O que deseja fazer?"
            + "\n[1] - Cadastrar funcionário"
            + "\n[2] - Listar funcionários"
            + "\n[0] - sair");
            int op = new Scanner(System.in).nextInt();

            switch (op) {
                case 1:
                    System.out.println("Digite o nome do funcionário:");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println("Digite o salário do funcionário:");
                    double salary = new Scanner(System.in).nextDouble();
        
                    Funcionario empregado = new Funcionario(name, salary);
                    boolean full = true;
                    for(int i = 0; i < employee.length;i++){
                        if(employee[i] == null){
                            full = false;
                            employee[i] = empregado;
                            break;
                        }
                    }
                    if(full){
                        System.out.println("Impossível cadastrar mais funcionários");
                    }
                    break;
                case 2:
                    for(int y = 0;y <= employee.length;y++){
                        System.out.println("[" + (y+1) + "] " + employee[y].getname());
                        System.out.println("Salário: " + employee[y].getwage());
                        System.out.println("Escolha um funcionário para ajustar seu salário");
                        int j = new Scanner(System.in).nextInt();
                        if(employee[j-1] == null){
                            System.out.println("Funcionário não cadastrado");
                        } else {
                            System.out.println("Digite o percentual de aumento de salário do funcionário " + employee[j-1].getname());
                            double percentage = new Scanner(System.in).nextDouble();
                            System.out.println("O novo salário do funcionário é: " + employee[j-1].increaseWage(percentage));
                        }
                    }
                    break;
                default:
                    quit = true;
                    break;
            }
        }
    }
}
