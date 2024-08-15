package Atividade01;

import java.util.Scanner;

public class Secundaria {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        System.out.println("Digite a cor da bola");
        String cor = new Scanner(System.in).nextLine();
        Bola b1 = new Bola(cor);
        System.out.println("A bola é da cor " + b1.getColor());
        System.out.println("Digite a nova cor da bola");
        cor = new Scanner(System.in).nextLine();
        b1.setColor(cor);
        System.out.println("A nova cor da bola é: " + cor);
    }
}
