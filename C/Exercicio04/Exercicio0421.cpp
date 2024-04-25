/*Faça um algoritmo que leia uma quantidade não determinada de números positivos. Calcule a 
quantidade de números pares e ímpares, a média de valores pares e a média geral dos números 
lidos. O número que encerrará a leitura será zero.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	int main(){
		int num, i = 0, even = 0, odd = 0, sum = 0, evenSum = 0;
		float avrg, evenAvrg;
		
		do{
			printf("Informe um numero: ");
			scanf(" %d", &num);
			sum += num;
			
			if(num % 2 == 0 && num != 0){
				evenSum += num;
				even++;
				evenAvrg = evenSum / even;
			}
			else if(num % 2 != 0){
				odd++;
			}
			i++;
			system("cls");
		}
		while(num != 0);
		avrg = sum / (i - 1);
		
		printf("Media: %.2f", avrg);
		printf("\nMedia dos numeros pares: %.2f", evenAvrg);
		printf("\nPares: %d", even);
		printf("\nImpares: %d", odd);
	}