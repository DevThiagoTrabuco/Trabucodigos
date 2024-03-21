/*Escreva um programa que lê o sexo de uma pessoa. O sexo deverá ser com o tipo de dado 
caractere e o programa deverá aceitar apenas os valores “M”, “F” ou “I”. O programa deve 
continuar pedindo o sexo enquanto o valor informado for diferente de “M”, “F” ou “I”.*/
#include<stdio.h>
#include<string.h>
#include<stdlib.h>

	int main(){
		char sex;
		
		do{
			printf("Informe o seu sexo (M - Masculino/F - Feminino/I - Indefinido):");
			scanf("%c", &sex);
			fflush(stdin);
		}
		while(sex == 'M' || sex == 'F' || sex == 'I');
		printf("Operacao encerrada.");
	}