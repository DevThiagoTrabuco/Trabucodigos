/*Faça um algoritmo que exiba a tabuada de um número x. Obs: tabuada: x*1, x*2 … x*10*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>
	
	int main(){
		int num, res, cont = 0;
		
		printf("Informe um numero para ver a sua tabuada: ");
		scanf("%d", &num);
		
		for(cont = 0;cont <= 10; cont++){
			res = num * cont;
			_sleep(250);
			printf("%d * %d = %d\n", num, cont, res);
		}
	}