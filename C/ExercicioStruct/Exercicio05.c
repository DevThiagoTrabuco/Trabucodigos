/*Defina uma estrutura Produto com os campos codigo, descricao, quantidade e
preco_unitario. Escreva um programa que permita ao usuário cadastrar os dados de até 5
produtos, armazená-los em um vetor de estruturas e, em seguida, exibir na tela o código, a
descrição e o preço total de cada produto (calculado multiplicando a quantidade pelo preço
unitário).*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	struct Product{
		char name[50];
		int qtd, code;
		float price, totalPrice = 0;
	};
	
	int main(){
		struct Product market[5];
		
		for(int i = 0;i < 5;i++){
			fflush(stdin);
			printf("Descricao item %d: ", i + 1);
			gets(market[i].name);
			printf("Codigo item %d: ", i + 1);
			scanf(" %d", &market[i].code);
			fflush(stdin);
			printf("Quantidade item %d: ", i + 1);
			scanf(" %d", &market[i].qtd);
			printf("Valor unitario item %d: ", i + 1);
			scanf(" %f", &market[i].price);
			
			system("cls");
			
			market[i].totalPrice = market[i].price * market[i].qtd;
		}
		
		system("cls");
		
		for(int i = 0;i < 5;i++){
			printf("PRODUTO %d", i + 1);
			printf("\nNome: %s", market[i].name);
			printf("\nCodigo: %d", market[i].code);
			printf("\nQuantidade: %d", market[i].qtd);
			printf("\nPreco total: %.2f\n\n", market[i].totalPrice);
		}
	}