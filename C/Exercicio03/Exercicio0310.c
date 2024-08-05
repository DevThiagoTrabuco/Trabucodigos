/*Desenvolver um algoritmo que receba o valor do salário de uma pessoa e o valor de um 
financiamento pretendido. Caso o financiamento seja menor ou igual a 5 vezes o salário da 
pessoa, o algoritmo deverá escrever "Financiamento Concedido"; senão, ele deverá escrever 
"Financiamento Negado".*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	int main(){
		char name[10];
		float slr, fnncng;
		
		printf("Informe o seu nome: ");
		scanf("%s", name);
		printf("Informe o seu salário: ");
		scanf("%f", &slr);
		fflush(stdin);
		printf("Informe o valor do financiamento desejado: ");
		scanf("%f", &fnncng);
		
		if(fnncng <= 5 * slr){
			printf("Financiamento CONCEDIDO.");
		}
		else{
			printf("Financiamento NEGADO.");
		}
	}
