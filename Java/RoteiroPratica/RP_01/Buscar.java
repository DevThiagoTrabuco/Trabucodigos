package RP_01;

import java.util.ArrayList;
import java.util.Scanner;

public class Buscar {
    @SuppressWarnings({ "resource", "unused" })
    public void search(ArrayList<Pessoa> Galera){
        if (Galera.isEmpty()){
            System.out.println("Não há pessoas cadastradas");
        } else {
            System.out.println("Digite o CPF da pessoa que está buscando");
            String cpf = new Scanner(System.in).nextLine();
            boolean found = false;

            for(Pessoa person : Galera){
                if(person.getcpf().equals(cpf)){
                    found = true;
                    System.out.println("Nome: " + person.getname()
                    + "\nCPF: " + person.getcpf()
                    + "\nAno de nascimento: " + person.getyear());
                    System.out.print("Pressione Enter para continuar");
                    String exit = new Scanner(System.in).nextLine();
                }
            }
            if(!found){
                System.out.println("Pessoa não encontrada.");
            }
        }
    }
}
