/*Crie um algoritmo que peça ao usuário que informe 
10 números inteiros, armazene-os em um vetor e apresente a soma de todos os valores*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	int main(){
		int v[10], sum = 0;
		
		for(int i = 0;i < 10;i++){
			/*v[i] = rand() % 50;
			printf("%d ", v[i]);*/ //Caso queira gerar os valores automaticamente
			printf("Declare um numero: ");
			scanf(" %d", &v[i]);
			sum += v[i];
		}
		printf("Soma: %d", sum);
	}