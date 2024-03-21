/*Faça um algoritmo que receba um número e diga se este número está no intervalo entre 100 e 200.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<locale.h>

	int main(){
		setlocale(LC_ALL, "portuguese");
		int num;
		
		printf("Forneça um número: ");
		scanf("%d", &num);
		
		if(num >= 100 && num <= 200){
			printf("Este número está no intervalo entre 100 e 200.");
		}
		else{
			printf("Este número não está no intervalo entre 100 e 200.");
		}
	}
