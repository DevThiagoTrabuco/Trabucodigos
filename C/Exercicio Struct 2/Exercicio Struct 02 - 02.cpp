/*Crie uma STRUCT chamada Pessoa com os campos nome, idade e altura. Em seguida,
escreva um programa em C que solicita ao usuário que insira os dados de duas pessoas e os
exiba na tela.*/
#include<stdio.h>
#include<string.h>
#include<locale.h>
#include<stdlib.h>

#define MAX_CHAR 100
#define MAX_INDIVIDUALS 2

typedef struct {
	char personName[MAX_CHAR];
	int personAge;
	float personHeight;
} People;

People persons[MAX_INDIVIDUALS];
int op, i = 0;

	int main(){
		setlocale(LC_ALL, "portuguese");
		while(op != 3){
			printf("1 - Cadastrar");
			printf("\n2 - Listar cadastros");
			printf("\n3 - Sair");
			printf("\nEscolha: ");
			scanf(" %d", &op);
			fflush(stdin);
			switch(op){
				case 1:
					system("cls");
					printf("Nome: ");
					gets(persons[i].personName);
					printf("Idade: ");
					scanf(" %d", &persons[i].personAge);
					printf("Altura: ");
					scanf(" %f", &persons[i].personHeight);
					i++;
					system("pause");
					system("cls");
					break;
				case 2:
					system("cls");
					for(int x = 0;x < i;x++){
						printf("Nome:\n%s", persons[x].personName);
						printf("\nIdade:\n%d", persons[x].personAge);
						printf("\nAltura:\n%.2f", persons[x].personHeight);
						printf("\n\n");
					}
					system("pause");
					system("cls");
					break;
				case 3:
					abort();
					break;
				default:
					break;
			}
		}
	}