package RoteiroPratica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    @SuppressWarnings({ "resource" })
    public static void main(String[] args) {
        List<Pessoa> Galera = new ArrayList<>();
        boolean quit = false;

        while(!quit){
            System.out.println("Bem vindo(a) ao sistema CHUPA - Cadastro Humano Universal Paulo Afonso" 
            + "\nEscolha uma opção"
            + "\n[1] - Cadastrar pessoa"
            + "\n[2] - Buscar pessoa"
            + "\n[0] - Sair");
            int op = new Scanner(System.in).nextInt();

            switch (op) {
                case 1:
                    Cadastrar register = new Cadastrar();
                    register.register((ArrayList<Pessoa>) Galera);
                break;
                case 2:
                    Buscar search = new Buscar();
                    search.search((ArrayList<Pessoa>) Galera);
                break;
                default:
                    quit = true;
                break;
            }
        }
    }
}
