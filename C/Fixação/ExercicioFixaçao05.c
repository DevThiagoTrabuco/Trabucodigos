#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<conio.h>

	int sum (int n1, int n2){
		int result = n1 + n2;
		return result;
	}
	
	int main(){
		int n1, n2, result;
		
		printf("Valor 1: ");
		scanf(" %d", &n1);
		printf("Valor 2: ");
		scanf(" %d", &n2);
		
		result = sum(n1, n2);
		
		printf("Resultado: %d", result);
	}
