package RoteiroPratica.RP02;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Principal {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		List <Pessoa> pessoas = new ArrayList<>();
		boolean quit = false;
		
		while(!quit){
			System.out.println("""
				Bem vindo(a) ao sistema CHUPA - Cadastro Humano Universal Paulo Afonso
				Escolha uma opção
				[1] - Pessoa Física
				[2] - Pessoa Jurídica
				[0] - Sair""");
				int op = new Scanner(System.in).nextInt();
				
				switch(op){
				case 1 -> {
					boolean quit2 = false;
					while(!quit2){	
						System.out.println("""
							MENU PESSOA FÍSICA
							Escolha uma opcão:
							[1] - Cadastrar Pessoa
							[2] - Editar Pessoa
							[3] - Buscar Pessoa
							[0] - Sair""");
						int op2 = new Scanner(System.in).nextInt();

						switch(op2){
							case 1 -> {
								System.out.println("Digite o nome, idade e cpf a ser cadastrado");
								String nome = new Scanner(System.in).nextLine();
								int idade = new Scanner(System.in).nextInt();
								String cpf = new Scanner(System.in).nextLine();
								int id = new Random().nextInt(100, 999);
								
								PessoaFisica pf = new PessoaFisica(id, idade, nome, cpf);
								pf.cadastrarPessoa(id, nome, idade, cpf, pessoas);

								System.out.println("Cadastro concluído" 
								+ "\nId: " + pf.getId()
								+ "\nNome: " + pf.getNome()
								+ "\nIdade: " + pf.getIdade()
								+ "\nCPF: " + pf.getCpf());
							}
							case 2 -> {
								System.out.println("Digite o id a ser editado");
								int id = new Scanner(System.in).nextInt();
							}
							case 3 -> {
								System.out.println("Digite o id a ser buscado");
								int id = new Scanner(System.in).nextInt();
							}
							default -> quit2 = true;
						}
					}
				}
				case 2 -> {
					boolean quit2 = false;
					while(!quit2){	
						System.out.println("""
							MENU PESSOA JURÍDICA
							Escolha uma opcão:
							[1] - Cadastrar Pessoa
							[2] - Editar Pessoa
							[3] - Buscar Pessoa
							[0] - Sair""");
						int op2 = new Scanner(System.in).nextInt();

						switch(op2){
							case 1 -> {
								System.out.println("Digite o nome, idade e cnpj a ser cadastrado");
								String nome = new Scanner(System.in).nextLine();
								int idade = new Scanner(System.in).nextInt();
								String cnpj = new Scanner(System.in).nextLine();
								int id = new Random().nextInt(100, 999);
								
								PessoaJuridica pj = new PessoaJuridica(id, idade, nome, cnpj);
								pj.cadastrarPessoa(id, nome, idade, cnpj, pessoas);

								System.out.println("Cadastro concluído" 
								+ "\nId: " + pj.getId()
								+ "\nNome: " + pj.getNome()
								+ "\nIdade: " + pj.getIdade()
								+ "\nCPF: " + pj.getCnpj());
							}
							case 2 -> {
								System.out.println("Digite o id a ser editado");
								int id = new Scanner(System.in).nextInt();
							}
							case 3 -> {
								System.out.println("Digite o id a ser buscado");
								int id = new Scanner(System.in).nextInt();
							}
							default -> quit2 = true;
						}
					}
				}
				default -> quit = true;
			}
		}
	}
}
