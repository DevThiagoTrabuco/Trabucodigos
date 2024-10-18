package RP_01;

import java.util.ArrayList;
import java.util.Scanner;

public class Cadastrar {
    @SuppressWarnings("resource")
    public void register(ArrayList<Pessoa> Galera){
        System.out.println("Digite o nome da pessoa:");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println("Digite o CPF da pessoa:");
                    String cpf = new Scanner(System.in).nextLine();
                    System.out.println("Digite o ano de nascimento da pessoa:");
                    int birthYear = new Scanner(System.in).nextInt();

                    Pessoa pessoa = new Pessoa(name, cpf, birthYear);
                    Galera.add(pessoa);
                    System.out.println("Pessoa cadastrada!");
    }
}
