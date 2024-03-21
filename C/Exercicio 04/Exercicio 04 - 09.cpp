/*Escreva um algoritmo que leia um valor inicial A e imprima a sequência de valores do cálculo de 
A! e o seu resultado. Ex: 5! = 5 X 4 X 3 X 2 X 1 = 120*/
#include<stdio.h>
#include<string.h>
#include<stdlib.h>

	int main(){
		int a, b, r = 1;
		
		printf("Escreva um numero: ");
		scanf("%d", &a);
		printf("%d! = ", a);
		for(b = a;b >= 2;b--){
			r *= b;
			printf("%d * ", b);
			if(b == 2){
				printf("1 = %d", r);
			}
		}
	}