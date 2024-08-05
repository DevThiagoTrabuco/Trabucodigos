/*Faça um algoritmo que leia e mostre um vetor de 10 números inteiros. 
A seguir, peça ao usuário para informar um valor inteiro e positivo 
e mostre todos os números do vetor que são divisíveis por esse número*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>

	int main(){
		int v[10], n;
		
		for(int i = 0;i < 10;i++){
			v[i] = rand() % 100;
			printf(" %d ", v[i]);
		}
		printf("\nDeclare um valor inteiro e positivo: ");
		scanf(" %d", &n);
		for(int i = 0;i < 10;i++){
			if(v[i] % n == 0 && v[i] != 0){
				printf(" %d; ", v[i]);
			}
		}
	}