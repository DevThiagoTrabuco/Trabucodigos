/*Escrever um algoritmo que lê 5 valores para A, um de cada vez, e conta quantos destes valores 
são negativos, escrevendo esta informação.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	int main(){
		int num;
		
		for(int i = 0;i < 5;i++){
			printf("Informe um numero: ");
			scanf("%d", &num);
		
			if(num < 0){
				printf("Este numero eh negativo.\n");
			}
			else if(num > 0){
				printf("Este numero eh positivo.\n");
			}
			if(num == 0){
				printf("Este numero eh zero.\n");
			}
		}
	}