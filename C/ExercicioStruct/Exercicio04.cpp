/*Crie uma estrutura Carro com os campos marca, modelo, ano e preco. Escreva um
programa que permita ao usuário cadastrar os dados de três carros, armazená-los em um
array de estruturas e, em seguida, exibir na tela o modelo, a marca e o ano de cada carro.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	struct Car {
		char model[50], brand[50];
		int year;
	};
	
	int main(){
		struct Car carFair[3];
		
		for(int i = 0;i < 3;i++){
			fflush(stdin);
			printf("Nome carro %d: ", i + 1);
			gets(carFair[i].model);
			printf("Marca carro %d: ", i + 1);
			gets(carFair[i].brand);
			fflush(stdin);
			printf("Ano carro %d: ", i + 1);
			scanf(" %d", &carFair[i].year);
			
			system("cls");
		}
		
		system("cls");
		
		for(int i = 0;i < 3;i++){
			printf("CARRO %d", i + 1);
			printf("\nNome: %s", carFair[i].model);
			printf("\nMarca: %s", carFair[i].brand);
			printf("\nAno: %d\n\n", carFair[i].year);
		}
	}