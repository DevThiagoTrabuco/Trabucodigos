package RP_02;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Principal {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		List <Pessoa> pessoas = new ArrayList<>();
		PessoaFisica pf = null;
		PessoaJuridica pj = null;
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
								
								pf = new PessoaFisica(id, idade, nome, cpf);
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
								
								if(pf.buscar(pessoas, id).equals("\nNão encontrado")){
									System.out.println("\nNão encontrado");
								}else {
									System.out.println(pf.buscar(pessoas, id)
											+"O que deseja alterar?"
											+ "\n1-Nome."
											+ "\n2-Idade."
											+ "\n3-Cpf."
											+ "\n4-Todos."
											+ "\n0-Sair.");
									op2 = new Scanner(System.in).nextInt();
									
									switch(op2) {
										case 1 -> {
											System.out.println("Digite o novo nome.");
											String nome = new Scanner(System.in).next();
											
											for (Pessoa pessoa : pessoas) {
												int index = pessoas.indexOf(pessoa);
												
												if(pessoas.get(index) instanceof PessoaFisica && pessoa.getId() == id) {
													pf= (PessoaFisica) pessoas.get(index);
													
													int idade = pf.getIdade();
													String cpf = pf.getCpf();
													
													pf.editar(pessoas, id, nome, cpf, idade);
													
													break;
												}
											}
										}
										case 2 -> {
											System.out.println("Digite a nova idade.");
											int idade = new Scanner(System.in).nextInt();
											String nome;
											for (Pessoa pessoa : pessoas) {
												int index = pessoas.indexOf(pessoa);
												
												if(pessoas.get(index) instanceof PessoaFisica && pessoa.getId() == id) {
													pf= (PessoaFisica) pessoas.get(index);
													
													nome = pf.getNome();
													String cpf = pf.getCpf();
													
													pf.editar(pessoas, id, nome, cpf, idade);
													break;
												}
											}
										}
										case 3 -> {
											System.out.println("Digite o novo cpf.");
											String cpf = new Scanner(System.in).next();
											int idade;
											String nome;
											for (Pessoa pessoa : pessoas) {
												int index = pessoas.indexOf(pessoa);
												
												if(pessoas.get(index) instanceof PessoaFisica && pessoa.getId() == id) {
													pf= (PessoaFisica) pessoas.get(index);
													
													idade = pf.getIdade();
													nome = pf.getNome();
													
													pf.editar(pessoas, id, nome, cpf, idade);
													break;
												}
											}
										}
										case 4 -> {
											System.out.println("Digite o novo nome, idade e cpf.");
											String nome = new Scanner(System.in).next();
											int idade = new Scanner(System.in).nextInt();
											String cpf = new Scanner(System.in).next();
											for (Pessoa pessoa : pessoas) {
												int index = pessoas.indexOf(pessoa);
												
												if(pessoas.get(index) instanceof PessoaFisica && pessoa.getId() == id) {
													pf= (PessoaFisica) pessoas.get(index);
													
													
													pf.editar(pessoas, id, nome, cpf, idade);
													break;
												}
											}
										}
										case 0 -> {
                                        }
										default -> {
                                        }
									}
								}
							}
							case 3 -> {
								System.out.println("Digite o id a ser buscado");
								int id = new Scanner(System.in).nextInt();
								
								String resultado = pf.buscar(pessoas, id);
								System.out.println(resultado);
										
									
								
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
								
								pj = new PessoaJuridica(id, idade, nome, cnpj);
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
								
								if(pj.buscar(pessoas, id).equals("\nNão encontrado")){
									System.out.println("\nNão encontrado");
								} else {
									System.out.println(pj.buscar(pessoas, id)
											+"O que deseja alterar?"
											+ "\n1-Nome."
											+ "\n2-Idade."
											+ "\n3-Cpf."
											+ "\n4-Todos."
											+ "\n0-Sair.");
									op2 = new Scanner(System.in).nextInt();
									
									switch(op2) {
										case 1 -> {
											System.out.println("Digite o novo nome.");
											String nome = new Scanner(System.in).next();
											
											for (Pessoa pessoa : pessoas) {
												int index = pessoas.indexOf(pessoa);
												
												if(pessoas.get(index) instanceof PessoaJuridica && pessoa.getId() == id) {
													pj = (PessoaJuridica) pessoas.get(index);
													
													int idade = pj.getIdade();
													String cnpj = pj.getCnpj();
													
													pj.editar(pessoas, id, nome, cnpj, idade);
													
													break;
												}
											}
										}
										case 2 -> {
											System.out.println("Digite a nova idade.");
											int idade = new Scanner(System.in).nextInt();
											String nome;
											for (Pessoa pessoa : pessoas) {
												int index = pessoas.indexOf(pessoa);
												
												if(pessoas.get(index) instanceof PessoaJuridica && pessoa.getId() == id) {
													pj = (PessoaJuridica) pessoas.get(index);
													
													nome = pj.getNome();
													String cnpj = pj.getCnpj();
													
													pj.editar(pessoas, id, nome, cnpj, idade);
													break;
												}
											}
										}
										case 3 -> {
											System.out.println("Digite o novo cnpj.");
											String cnpj = new Scanner(System.in).next();
											int idade;
											String nome;
											for (Pessoa pessoa : pessoas) {
												int index = pessoas.indexOf(pessoa);
												
												if(pessoas.get(index) instanceof PessoaJuridica && pessoa.getId() == id) {
													pj = (PessoaJuridica) pessoas.get(index);
													
													idade = pj.getIdade();
													nome = pj.getNome();
													
													pj.editar(pessoas, id, nome, cnpj, idade);
													break;
												}
											}
										}
										case 4 -> {
											System.out.println("Digite o novo nome, idade e cnpj.");
											String nome = new Scanner(System.in).next();
											int idade = new Scanner(System.in).nextInt();
											String cnpj = new Scanner(System.in).next();
											for (Pessoa pessoa : pessoas) {
												int index = pessoas.indexOf(pessoa);
												
												if(pessoas.get(index) instanceof PessoaJuridica && pessoa.getId() == id) {
													pj = (PessoaJuridica) pessoas.get(index);
													
													
													pj.editar(pessoas, id, nome, cnpj, idade);
													break;
												}
											}
										}
										case 0 -> {
										}
										default -> {
										}
									}
								}
							}
							case 3 -> {
								System.out.println("Digite o id a ser buscado");
								int id = new Scanner(System.in).nextInt();
								
								String resultado = pj.buscar(pessoas, id);
								System.out.println(resultado);
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
