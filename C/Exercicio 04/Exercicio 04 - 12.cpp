/*Implementar um algoritmo para somar valores até o usuário digitar o valor 0. Ou seja, vamos 
somar todos os valores que o usuário digitar, porém quando ele digitar 0 o "loop" acaba.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>

	int main(){
		int n1, n2, sum;
		printf("Forneca um numero: ");
		scanf("%d", &n1);
		if(n1 != 0){
			printf("Forneca um numero: ");
			scanf("%d", &n2);
			if(n2 != 0){
				sum = n1 + n2;
				while(n2 != 0){
					printf("Forneca um numero: ");
					scanf("%d", &n2);
					if(n2 != 0){
						sum += n2;
					}
				}
				printf("Soma: %d\n", sum);
			}
		}
	}