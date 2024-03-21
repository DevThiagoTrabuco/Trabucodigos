/*Escrever um algoritmo que gera e escreve os números ímpares entre 100 e 200.*/
#include<stdio.h>
#include<stdlib.h>
#include<time.h>

	int main(){
		for(int i = 100;i <= 200;i++){
			if(i % 2 != 0){
				_sleep(100);
				printf("%d;\n", i);
			}
		}
	}