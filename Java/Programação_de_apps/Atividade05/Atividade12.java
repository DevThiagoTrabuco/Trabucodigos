package Atividade05;

import java.util.Scanner;

public class Atividade12 {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Funcionario[] employee = new Funcionario[3];
        boolean quit = false;
        while(!quit){
            boolean empty = true;
            for(int i = 0; i < employee.length;i++){
                if(employee[i] != null){
                    empty = false;
                }
            }

            System.out.println("Bem vindo ao sistema de controle de Funcionários");
            System.out.println("O que deseja fazer?"
            + "\n[1] - Cadastrar funcionário"
            + "\n[2] - Listar funcionários"
            + "\n[3] - Remover funcionário"
            + "\n[0] - Sair");
            int op = new Scanner(System.in).nextInt();

            switch(op) {
                case 1:
                    System.out.println("Digite o nome do funcionário");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println("Digite o salário do funcionário");
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
                    if(!empty){
                        boolean found = false;
                        for(int i = 0; i < employee.length; i++){
                            if(employee[i] != null){
                                System.out.println("["+(i+1)+"] " + employee[i].getname());
                            }
                        }
                        System.out.println("Digite o nome do funcionário que deseja incrementar o salário");
                        String n = new Scanner(System.in).nextLine();
                        for(int i = 0; i < employee.length;i++){
                            if(employee[i].getname().equals(n)){
                                found = true;
                                System.out.println("Salário atual: " + employee[i].getwage());
                                System.out.println("Digite o percentual de aumento de salário");
                                double percentage = new Scanner(System.in).nextDouble();
                                employee[i].increaseWage(percentage);
                                System.out.println("O novo salário do funcionário é: " + employee[i].getwage());
                                break;
                            }
                            if(!found){
                                System.out.println("Funcionário não encontrado");
                            }
                        }
                    } else {
                        System.out.println("Sem funcionários cadastrados");
                    }
                    break;
                case 3:
                    if(!empty){
                        boolean found = false;
                        for(int i = 0; i < employee.length; i++){
                            if(employee[i] != null){
                                System.out.println("["+(i+1)+"] " + employee[i].getname());
                            }
                        }
                        System.out.println("Digite o nome do funcionário que deseja remover");
                        String n = new Scanner(System.in).nextLine();
                        for(int i = 0; i < employee.length;i++){
                            if(employee[i].getname().equals(n)){
                                employee[i] = null;
                                found = true;
                                break;
                            }
                        } 
                        if(!found){
                            System.out.println("Funcionário não encontrado");
                        }
                    } else {
                        System.out.println("Sem funcionários cadastrados");
                    }
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    break;
            }
        }
    }
} 