/*Faça um algoritmo que leia dois valores inteiros A e B se os valores forem iguais deverá se
somar os dois, caso contrário multiplique A por B. Ao final de qualquer um dos cálculos deve-se
atribuir o resultado para uma variável C e mostrar seu conteúdo na tela.*/	
#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<string.h>
#include<ctype.h>

	int main(){
		int a, b, c;
		
		printf("Informe um valor A: ");
		scanf("%d", &a);
		printf("Informe um valor B: ");
		scanf("%d", &b);
		
		system("cls");
		
		if(a == b){
			c = a + b;
			printf("O valor de C eh igual a: %d", c);
		}
		else{
			c = a * b;
			printf("O valor de C eh igual a : %d", c);
		}
	}
