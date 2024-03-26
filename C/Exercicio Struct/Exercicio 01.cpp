/*Crie uma estrutura chamada Aluno com os seguintes campos: nome, idade, matricula e
nota. Em seguida, escreva um programa que cadastre os dados de três alunos, armazene-os
em um array de estruturas e depois exiba esses dados na tela.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	struct Student {
		char name[50];
		int age, rgstr;
		float grd;
	};
	
	int main(){
		struct Student stdnt[3];
		
		for(int i = 0;i < 3;i++){
			fflush(stdin);
			printf("Nome aluno %d: ", i + 1);
			gets(stdnt[i].name);
			printf("Idade aluno %d: ", i + 1);
			scanf(" %d", &stdnt[i].age);
			printf("Matricula aluno %d: ", i + 1);
			scanf(" %d", &stdnt[i].rgstr);
			printf("Nota aluno %d: ", i + 1);
			scanf(" %f", &stdnt[i].grd);
			
			system("cls");
		}
		
		system("cls");
		
		for(int i = 0;i < 3;i++){
			printf("ALUNO %d", i + 1);
			printf("\nNome: %s", stdnt[i].name);
			printf("\nIdade: %d", stdnt[i].age);
			printf("\nMatricula: %d", stdnt[i].rgstr);
			printf("\nNota: %.2f\n\n", stdnt[i].grd);
		}
	}