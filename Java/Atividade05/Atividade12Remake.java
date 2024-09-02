package Atividade05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Atividade12Remake {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        List<Funcionario> Employees = new ArrayList<>();
        boolean quit = false;

        while(!quit){
            System.out.println("Bem vindo ao sistema de gerenciamento de funcionários"
            + "\nEscolha uma opção:"
            + "\n[1] - Cadastrar funcionário"
            + "\n[2] - Listar funcionários"
            + "\n[3] - Remover funcionário"
            + "\n[Outro número] - Sair");
            int op = new Scanner(System.in).nextInt();

            switch (op) {
                case 1:
                    System.out.println("Digite o nome e salário do funcionário:");
                    String name = new Scanner(System.in).nextLine();
                    double salary = new Scanner(System.in).nextDouble();

                    Funcionario worker = new Funcionario(name, salary);
                    Employees.add(worker);
                    System.out.println("Funcionário cadastrado com sucesso.");
                    break;
                case 2:
                    if(Employees.isEmpty()){
                        System.out.println("Não há funcionários cadastrados.");
                    } else {
                        int i = 1;    
                        for(Funcionario empregado : Employees){ 
                            System.out.println("["+i+"] " + empregado.getname());
                            i++;
                        }   
                        System.out.println("Digite o nome do funcionário que deseja alterar o salário, ou 'X' para sair.");
                        String choice = new Scanner(System.in).nextLine();
                        boolean found = false;
                        if(choice.equalsIgnoreCase("x")){
                            break;
                        } else {
                            for(Funcionario empregado : Employees){
                                if(empregado.getname().equals(choice)){
                                    found = true;
                                    System.out.println("Digite a porcentagem de ajuste");
                                    double percentage = new Scanner(System.in).nextDouble();

                                    int index = Employees.indexOf(empregado);
                                    Employees.get(index).increaseWage(percentage);
                                    System.out.println("O salário atual do funcionário é: " 
                                    + Employees.get(index).getwage());
                                    break;
                                }
                            }
                            if(!found){
                                System.out.println("Funcionário não encontrado");
                            }
                        }
                    }
                    break;
                case 3:
                    if(Employees.isEmpty()){
                        System.out.println("Não há funcionários cadastrados.");
                    } else {
                        System.out.println("Digite o nome do funcionário a ser removido:");
                        String n = new Scanner(System.in).nextLine();
                        boolean found = false;
                        
                        for(Funcionario empregado : Employees){
                            if(empregado.getname().equals(n)){
                                found = true;
                                Employees.remove(empregado);
                                System.out.println("Funcionário removido.");
                                break;
                            }
                        }
                        if(!found){
                            System.out.println("Funcionário não encontrado.");
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
