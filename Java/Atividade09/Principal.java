package Atividade09;

import java.util.Scanner;

public class Principal {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        System.out.println("Qual o modelo do seu carro?");
        String modelo = new Scanner(System.in).nextLine();
        System.out.println("Qual o consumo deste modelo (km/Litro)");
        double consumo = new Scanner(System.in).nextDouble();

        Carro c1 = new Carro(modelo, consumo);
        int op = 9;
        double distance = 0;
        
        while(op != 0){
            System.out.println("Modelo: " + c1.getmodel());
            System.out.println("Consumo: " + c1.getfuelUse());
            System.out.println("Combustível: " + c1.getfuel());
            System.out.println("O que deseja fazer?\n[1] - Dirigir\n[2] - Abastecer\n[0] - Sair do carro");
            op = new Scanner(System.in).nextInt();

            switch (op) {
                case 1:
                    if(c1.getfuel() == 0){
                        System.out.println("Sem combustível, por favor abasteça.");
                    } else {
                        System.out.println("Qual a distância (em Km) a ser percorrida?");
                        distance = new Scanner(System.in).nextDouble();
                        if((distance * c1.getfuelUse()) > c1.getfuel()){
                            System.out.println("Combustível insuficiente, por favor abasteça.");
                        } else {
                            c1.drive(distance);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Qual a quantidade (em Litros) a ser abastecida?");
                    double gas = new Scanner(System.in).nextDouble();
                    if(gas > 0){
                        c1.refuel(gas);
                    } else {
                        break;
                    }
                break;
                default:
                    op = 0;
                break;
            }
        }
    }
}
