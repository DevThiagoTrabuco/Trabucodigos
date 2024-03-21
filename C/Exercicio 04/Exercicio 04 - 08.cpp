/*Desenvolver um algoritmo que efetue a soma de todos os números ímpares que são múltiplos 
de três e que se encontram no conjunto dos números de 1 até 500.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>

	int main(){
		int sum = 0;
		
		for(int i = 1;i < 500;i++){
			if(i % 2 != 0 && i % 3 == 0){
				_sleep(50);
				printf("%d;\n", i);
				sum += i;
			}
		}
		printf("Soma: %d", sum);
	}