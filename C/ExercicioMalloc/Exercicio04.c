//Algoritmo simples 4:
#include<stdio.h>
#include<stdlib.h>

int main( ) {
	int *a;
	
	a = (int *) malloc(sizeof(int));
	
	printf("Digite um valor: ");
	scanf("%d", &a);
	printf("Valor: %d", a);
	
	return 0;
}