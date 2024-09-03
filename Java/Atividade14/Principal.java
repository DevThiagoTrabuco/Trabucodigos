package Atividade14;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Principal {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        List<BombaCombustivel> Bomba = new ArrayList<>();
        boolean quit = false;

        while(!quit){
            System.out.println("Bem vindo(a) adminstrador do posto PUTA - Posto Universal Tancredo Alvares."
            + "\nEscolha uma opção:"
            + "\n[1] - Cadastrar nova Bomba de Combustível"
            + "\n[2] - Editar Bomba de Combustível"
            + "\n[3] - Remover Bomba de Combustível"
            + "\n[Outro número] - Sair");
            int op = new Scanner(System.in).nextInt();

            switch (op) {
                case 1:
                    System.out.println("Digite o tipo de combustível da bomba");
                    String fuelType = new Scanner(System.in).nextLine();
                    System.out.println("Digite o valor por litro de combustível");
                    double priceByLiter = new Scanner(System.in).nextDouble();
                    System.out.println("Quanto de combustível tem na bomba?");
                    double fuelQtt = new Scanner(System.in).nextDouble();
                    int num = new Random().nextInt(100, 999);
                    String id = String.valueOf(num);

                    BombaCombustivel bomba = new BombaCombustivel(id, fuelType, priceByLiter, fuelQtt);
                    Bomba.add(bomba);
                    System.out.println("Bomba cadastrada."
                    + "\nNº de identificação: " + id);
                    break;
                case 2:
                    if(Bomba.isEmpty()){
                        System.out.println("Não há bombas cadastradas.");
                    } else {
                        for(BombaCombustivel pump : Bomba){
                            System.out.println(pump.getid() +" - "+ pump.gettype());
                        }
                        System.out.println("Escolha qual bomba deseja editar");
                        id = new Scanner(System.in).nextLine();
                        boolean found = false;

                        for(BombaCombustivel pump : Bomba){
                            if(pump.getid().equals(id)){
                                found = true;
                                boolean quit2 = false;
                                int index = Bomba.indexOf(pump);

                                while(!quit2){
                                    System.out.println("Bomba: " + Bomba.get(index).getid()
                                    + "\nTipo de combustível: " + Bomba.get(index).gettype()
                                    + "\nValor por litro: R$ " + Bomba.get(index).getprice()
                                    + "\nVolume atual(L): " + Bomba.get(index).getqtt()
                                    + "\nEscolha uma opção:"
                                    + "\n[1] - Editar tipo de combustível"
                                    + "\n[2] - Editar valor por litro"
                                    + "\n[3] - Editar quantidade de combustível"
                                    + "\n[4] - Abastecer por valor"
                                    + "\n[5] - Abastecer por quantidade"
                                    + "\n[Outro número] - Sair");
                                    int choice = new Scanner(System.in).nextInt();

                                    if(choice == 1){
                                        System.out.println("Digite o tipo de combustível a ser cadastrado:");
                                        String tipo = new Scanner(System.in).nextLine();
                                        Bomba.get(index).settype(tipo);
                                        System.out.println("O novo tipo de combustível da bomba " 
                                        + Bomba.get(index).getid() + " é " + Bomba.get(index).gettype());
                                    } else if(choice == 2){
                                        System.out.println("Digite o novo valor a ser cadastrado");
                                        double preco = new Scanner(System.in).nextDouble();
                                        Bomba.get(index).setprice(preco);
                                        System.out.println("O novo valor por litro de combustível da bomba " 
                                        + Bomba.get(index).getid() + " é " + Bomba.get(index).getprice());
                                    } else if(choice == 3){
                                        System.out.println("Digite a nova quantidade de combustível a ser cadastrada");
                                        double qtt = new Scanner(System.in).nextDouble();
                                        Bomba.get(index).setqtt(qtt);;
                                        System.out.println("O volume de combustível da bomba " 
                                        + Bomba.get(index).getid() + " é " + Bomba.get(index).getqtt());
                                    } else if(choice == 4){
                                        System.out.println("Qual o valor a ser abastecido?");
                                        double valor = new Scanner(System.in).nextDouble();
                                        Bomba.get(index).fillByPrice(valor);
                                    } else if(choice == 5){
                                        System.out.println("Qual o volume, em L, a ser abastecido?");
                                        double volume = new Scanner(System.in).nextDouble();
                                        Bomba.get(index).fillByVolume(volume);
                                    } else {
                                        quit2 = true;
                                    }
                                }
                                break;
                            }
                        }
                        if(!found){
                            System.out.println("Bomba não cadastrada.");
                        }
                    }
                    break;
                case 3:
                    if(Bomba.isEmpty()){
                        System.out.println("Não há bombas cadastradas.");
                    } else {
                        System.out.println("Digite o nº de identificação da Bomba.");
                        id = new Scanner(System.in).nextLine();
                        boolean found = false;

                        for(BombaCombustivel pump : Bomba){
                            if(pump.getid().equals(id)){
                                found = true;
                                Bomba.remove(pump);
                                System.out.println("Bomba " + pump.getid() + " removida com sucesso.");
                                break;
                            }
                        }
                        if(!found){
                            System.out.println("Bomba não encontrada.");
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
