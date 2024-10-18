package RP_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    @SuppressWarnings({ "resource" })
    public static void main(String[] args) {
        List<Pessoa> Galera = new ArrayList<>();
        boolean quit = false;

        while(!quit){
            System.out.println("""
                               Bem vindo(a) ao sistema CHUPA - Cadastro Humano Universal Paulo Afonso
                               Escolha uma opção
                               [1] - Cadastrar pessoa
                               [2] - Buscar pessoa
                               [0] - Sair""");
            int op = new Scanner(System.in).nextInt();

            switch (op) {
                case 1 -> {
                    Cadastrar register = new Cadastrar();
                    register.register((ArrayList<Pessoa>) Galera);
                }
                case 2 -> {
                    Buscar search = new Buscar();
                    search.search((ArrayList<Pessoa>) Galera);
                }
                default -> quit = true;
            }
        }
    }
}
