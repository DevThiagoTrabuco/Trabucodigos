/*Desenvolva uma estrutura chamada Livro que tenha os campos titulo, autor,
ano_publicacao e preco. Escreva um programa que permita ao usu�rio cadastrar os dados
de at� 10 livros, armazen�-los em um array de estruturas e, em seguida, exibir na tela o
t�tulo e o autor de cada livro.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	struct Book {
		char bookName[50], author[50];
		int year;
		float price;
	};
	
	int main(){
		struct Book bookFair[10];
		
		for(int i = 0;i < 10;i++){
			fflush(stdin);
			printf("Nome livro %d: ", i + 1);
			gets(bookFair[i].bookName);
			printf("Autor livro %d: ", i + 1);
			gets(bookFair[i].author);
			fflush(stdin);
			printf("Ano publicacao livro %d: ", i + 1);
			scanf(" %d", &bookFair[i].year);
			printf("Preco livro %d: ", i + 1);
			scanf(" %f", &bookFair[i].price);
			
			system("cls");
		}
		
		system("cls");
		
		for(int i = 0;i < 10;i++){
			printf("LIVRO %d", i + 1);
			printf("\nNome: %s", bookFair[i].bookName);
			printf("\nAutor: %s\n\n", bookFair[i].author);
		}
	}