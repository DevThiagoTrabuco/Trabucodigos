#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<string.h>
/*Faça um algoritmo que leia os valores A, B, C e imprima na tela se a soma de A + B é menor que C.*/
	int main(){
		int a, b, c, sum;
		
		printf("Informe um valor A:\n");
		scanf("%d", &a);
		
		system("cls");
	
		printf("Informe um valor B:\n");
		scanf("%d", &b);
		
		system("cls");
		
		printf("Informe um valor C:\n");
		scanf("%d", &c);
		
		sum = a + b;
		
		/*system("pause");*/
		system("cls");
		
		
		if(sum < c){
			printf("A soma %d + %d eh menor que %d.", a, b, c);
		}
		else if(sum > c){
			printf("A soma %d + %d eh maior que %d.", a, b, c);
		}
		else{
			printf("A soma %d + %d eh igual a %d.", a, b, c);
		}
	}
