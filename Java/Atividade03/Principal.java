package Atividade03;

import java.util.Scanner;

public class Principal {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(3, 5);
        System.out.println("Altura do retangulo: " + r1.getheight());
        System.out.println("Base do retangulo: " + r1.getbase());
        System.out.println("Area do retangulo: " + r1.calcularArea(r1.getbase(), r1.getheight()));
        System.out.println("Perimetro do retangulo: " + r1.calcularPerimetro(r1.getbase(), r1.getheight()));

        System.out.println("Digite a nova base do retangulo:");
        int base = new Scanner(System.in).nextInt();
        r1.setbase(base);
        System.out.println("Digite a nova altura do retangulo:");
        int height = new Scanner(System.in).nextInt();
        r1.setheigth(height);

        System.out.println("Altura do retangulo: " + r1.getheight());
        System.out.println("Base do retangulo: " + r1.getbase());
        System.out.println("Area do retangulo: " + r1.calcularArea(r1.getbase(), r1.getheight()));
        System.out.println("Perimetro do retangulo: " + r1.calcularPerimetro(r1.getbase(), r1.getheight()));
    }
}
