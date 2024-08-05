/* Escrever um algoritmo que leia três valores inteiros distintos e os escreva em ordem crescente*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	int main(){
		int a, b, c;
		
		printf("Informe um número A: ");
		scanf("%d", &a);
		printf("Informe um número B: ");
		scanf("%d", &b);
		printf("Informe um número C: ");
		scanf("%d", &c);
		
		if(a == b && a == c){
			printf("Forneça números distintos");
		}
		else if(a > b && a > c){
			if(b > c){
				printf("%d, %d, %d", c, b, a);
			}
			else{
				printf("%d, %d, %d", b, c, a);
			}
		}
		else if(b > a && b > c){
			if(a > c){
				printf("%d, %d, %d", c, a, b);
			}
			else{
				printf("%d, %d, %d", a, c, b);
			}
		}
		else{
			if(a > b){
				printf("%d, %d, %d", b, a, c);
			}
			else{
				printf("%d, %d, %d", a, b, c);
			}
		}
	}