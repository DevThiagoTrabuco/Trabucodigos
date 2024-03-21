/*Escrever um programa de computador que leia 10 números inteiros e, ao final, apresente a 
soma de todos os números lidos.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	int main(){
		int num, sum = 0;
		for(int i = 0;i < 10;i++){
			printf("Escreva um numero: ");
			scanf("%d", &num);
			sum += num;
		}
		printf("Soma: %d", sum);
	}