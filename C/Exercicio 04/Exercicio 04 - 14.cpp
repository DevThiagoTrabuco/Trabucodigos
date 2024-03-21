/*Desenvolver um algoritmo que leia um número não determinado de valores e calcule e escreva a 
média aritmética dos valores lidos, a quantidade de valores positivos e a quantidade de valores 
negativos. Quando digitar zero o programa deve finalizar.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	int main(){
		int num, i = 1, pos = 0, neg = 0, sum = 0;
		float avrg;
		
		do{
			printf("Forneca um numero: ");
			scanf("%d", &num);
			sum += num;
			
			if(num > 0){
				pos++;
			}
			if(num < 0){
				neg++;
			}
			i++;
		}
		while(num != 0);
		
		avrg = sum / (i - 1);
		
		printf("Media: %.2f", avrg);
		printf("\nNumeros positivos: %d", pos);
		printf("\nNumeros negativos: %d", neg);
	}