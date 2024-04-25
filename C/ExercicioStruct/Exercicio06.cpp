/*Crie uma estrutura Pessoa com os campos nome, idade, sexo e altura. Escreva um
programa que permita ao usuário cadastrar os dados de cinco pessoas, armazená-los em
um array de estruturas e, em seguida, exibir na tela o nome e a idade de todas as pessoas
cadastradas.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	struct Person {
		char name[50], gender;
		int age;
		float height;
	};
	
	int main(){
		struct Person people[5];
		
		for(int i = 0;i < 5;i++){
			fflush(stdin);
			printf("Nome pessoa %d: ", i + 1);
			gets(people[i].name);
			printf("Idade pessoa %d: ", i + 1);
			scanf(" %d", &people[i].age);
			printf("Genero pessoa %d: ", i + 1);
			scanf(" %c", &people[i].gender);
			printf("altura pessoa %d: ", i + 1);
			scanf(" %f", &people[i].height);
		}
		
		system("cls");
		
		for(int i = 0;i < 5;i++){
			printf("PESSOA %d", i + 1);
			printf("\nNome: %s", people[i].name);
			printf("\nIdade: %d\n\n", people[i].age);
		}
	}