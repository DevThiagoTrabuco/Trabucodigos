/*Faça um algoritmo que leia e mostre um vetor de 5 números inteiros. 
A seguir, inverta os valores desse vetor, exibindo novamente o vetor invertido*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	int main(){
		int v[5];
		
		for(int i = 0;i < 5;i++){
			printf("Declare um numero: ");
			scanf(" %d", &v[i]);
		}
		for(int i = 4;i >= 0;i--){
			printf("%d ", v[i]);
		}
	}