/*Escreva um algoritmo que gere os números de 1000 a 1999 e escreva aqueles que dividido por 
11 dão resto igual a 5.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>

	int main(){
		for(int num = 1000;num <= 1999;num++){
			if(num % 11 == 5){
				_sleep(100);
				printf("%d\n", num);
			}
		}
	}
