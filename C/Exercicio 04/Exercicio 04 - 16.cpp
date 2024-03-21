/*Escrever um algoritmo que leia um valor para uma variável N de 1 a 10 e calcule a tabuada de 
N. Mostre a tabuada na forma: 0 x N = 0, 1 x N = 1N, 2 x N = 2N, ..., 10 x N = 10N.*/
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