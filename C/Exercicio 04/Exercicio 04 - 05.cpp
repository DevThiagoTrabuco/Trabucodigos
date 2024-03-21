/*Escreva um algoritmo que calcule a média dos números digitados pelo usuário, se eles forem 
pares. Termine a leitura se o usuário digitar zero (0).*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	int main(){
		int num, sum = 0, cont = 0;
		float avrg;
		
		do{
			printf("Informe um numero: ");
			scanf("%d", &num);
			if(num % 2 == 0 && num != 0){
				cont++;
				sum += num;
			}
		}
		while(num != 0);
		avrg = sum / cont;
		printf("Media: %.1f", avrg);
	}