/*Escreva um algoritmo que leia 20 valores inteiros e ao final exiba a soma dos números positivos.*/
#include<stdio.h>
#include<stdlib.h>
#include<conio.h>

	int main(){
		int num, sum = 0;
		
		for(int i = 1;i <= 20;i++){
			printf("Escreva um numero: ");
			scanf("%d", &num);
			if(num > 0){
				sum += num;
			}
		}
		printf("Soma: %d", sum);
	}