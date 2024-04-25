/*Desenvolva uma estrutura chamada Livro que tenha os campos titulo, autor,
ano_publicacao e preco. Escreva um programa que permita ao usuário cadastrar os dados
de até 10 livros, armazená-los em um array de estruturas e, em seguida, exibir na tela o
título e o autor de cada livro.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>

#define size 2

	typedef struct {
		char bookTitle[50], author[50];
		int year;
		float price;
	} Book;
	
	Book bookFair[size];
	int bookNum = 0;
	
	bool fullList(){
		if(bookNum == size){
			return true;
		}
		return false;
	}
	
	bool emptyList(){
		if(bookNum == 0){
			return true;
		}
		return false;
	}
	
	void registerBook(){
		if(fullList()){
			printf("###LISTA CHEIA###");
		}
		else{
			for(int i = 0;i < size;i++){
				fflush(stdin);
				printf("Titulo livro %d: ", i + 1);
				gets(bookFair[i].bookTitle);
				printf("Autor livro %d: ", i + 1);
				gets(bookFair[i].author);
				fflush(stdin);
				printf("Ano publicacao livro %d: ", i + 1);
				scanf(" %d", &bookFair[i].year);
				printf("Preco livro %d: ", i + 1);
				scanf(" %f", &bookFair[i].price);
				bookNum++;
				system("cls");
			}
		}
	}

	void bookList(){
		if(emptyList()){
			printf("###LISTA VAZIA###\n");
		}
		else{
				printf("LIVROS\n\n");
			for(int i = 0;i < size;i++){
				printf("-------------------\n");
				printf("\nNome: %s", bookFair[i].bookTitle);
				printf("\nAutor: %s\n\n", bookFair[i].author);
			}
		}
	}
	
	void bookSearch(){
		char title[50];
		if(emptyList()){
			printf("###LISTA VAZIA###\n");
		}
		else{
			printf("Digite o titulo a ser procurado:\n");
			scanf(" %s", &title);
			
			system("cls");
			
			bool found = false;
			for(int i = 0;i < size;i++){	
				if(strcmp(bookFair[i].bookTitle, title) == 0){
					printf("LIVRO");
					printf("\nNome: %s", bookFair[i].bookTitle);
					printf("\nAutor: %s\n\n", bookFair[i].author);
					found = true;
					break;
				}
			}
			if(!found){
				printf("###LIVRO NAO ENCONTRADO###\n");
			}
		}
	}

	void control(int choice){
		char title[50];
		switch(choice){
			case 1:
				registerBook();
				break;
			case 2:
				bookList();
				break;
			case 3:
				bookSearch();
				break;
			case 4:
				abort();
			 	break;
			default:
				printf("###OPCAO INVALIDA###\n");
				break;
		}
	}
	
	void menu(){
		int choice;

		printf("\t###MENU###\n");
		printf("\n1 - Cadastrar livro");
		printf("\n2 - Listar livros cadastrados");
		printf("\n3 - Buscar livro por nome");
		printf("\n4 - Sair\n");
		scanf(" %d", &choice);
		
		system("cls");
		
		control(choice);
	}	
	
	int main(){
		while(true){
			menu();
			system("pause");
			system("cls");
		}
	}