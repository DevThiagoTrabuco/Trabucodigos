package Atividade05;

import java.util.Scanner;

public class Principal {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        System.out.println("Digite o nome do funcionário:");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Digite o salário do funcionário:");
        double salary = new Scanner(System.in).nextDouble();

        Funcionario f1 = new Funcionario(name, salary);

        System.out.println("Nome do funcionário: " + f1.getname());
        System.out.println("Salário do funcionário: " + f1.getwage());
        System.out.println("Digite o percentual de aumento de salário do funcionário");
        double percentage = new Scanner(System.in).nextDouble();
        System.out.println("O novo salário do funcionário é: " + f1.increaseWage(percentage));
    }
}
