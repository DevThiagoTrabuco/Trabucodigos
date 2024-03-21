/*Crie um algoritmo que peça ao usuário que informe 10 
números inteiros e armazene-os em um vetor. A seguir, apresente 
a multiplicação de todos os números pares e a soma de todos os elementos ímpares*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	int main(){
		int v[10], sum = 0, prod = 1;
		
		for(int i = 0;i < 10; i++){
			v[i] = rand() % 15;
			printf("%d ", v[i]);
			/*printf("Declare um numero: ");
			scanf(" %d", &v[i]);
			system("cls");*/ //Caso queira informar os valores manualmente
			if(v[i] % 2 == 0 && v[i] != 0){
				prod *= v[i];
			}
			if(v[i] % 2 != 0){
				sum += v[i];
			}
		}
		printf("\nSoma: %d", sum);
		printf("\nProduto: %d", prod);
	}