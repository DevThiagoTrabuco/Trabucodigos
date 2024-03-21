//Faça um algoritmo que leia o nome, o sexo e o estado civil de uma pessoa. Caso sexo seja “F” e estado civil seja “CASADA”, solicitar o tempo de casada (anos).
#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<string.h>//função strcmp()
#include<ctype.h> //função toupper()
#include<locale.h>//função setLocale -> definir localidade
	int main(){
		setlocale(LC_ALL, "portuguese");
		char name[40], sex, rltn[10];
		int time;
		
		printf("Forneça o seu nome:\n");
		scanf("%s", name);
		
		fflush(stdin);//Limpa o buffer
		system("cls");
		
		printf("Informe seu sexo (F/M):\n");
		scanf("%c", &sex);
		
		system("cls");
		
		printf("Informe seu estado civil:\n");
		scanf("%s", rltn);

		if(sex == 'F' && strcmp(rltn, "casada") == 0){// == não faz comparação de vetor
			printf("Informe quantos anos tem de casada:\n");
			scanf("%d", &time);
			fflush(stdin);
		}
		else if(sex == 'F' && strcmp(rltn, "solteira") == 0){
			printf("Tem zap gata?");
		}
		else{
			printf("Fodase mano.");
		}
	}