package Atividade06;

import java.util.Scanner;

public class Principal {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escreva o seu nome");
        String nome = new Scanner(System.in).nextLine();
        System.out.println("Escreva a sua idade");
        int idade = new Scanner(System.in).nextInt();
        System.out.println("Escreva o seu peso");
        double peso = new Scanner(System.in).nextDouble();
        System.out.println("Escreva a sua altura");
        double altura = new Scanner(System.in).nextDouble();

        Pessoa eu = new Pessoa(nome, idade, peso, altura);

        while(eu.getage() <= 60){
            System.out.println("Nome:" + eu.getname());
            System.out.println("Idade: " + eu.getage());
            System.out.println("Peso: " + eu.getweight());
            System.out.println("Altura: " + eu.getheight());
            eu.growOld();
            eu.grow();
            eu.gainWeight(1.50);
            eu.loseWeight(1.50);
            scanner.nextLine();
        }
    }
}
