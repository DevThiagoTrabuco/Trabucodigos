//Algoritmo com função 2:
#include<stdio.h>
#include<stdlib.h>

int ler( ) {
	int a;
	
	printf("Digite um valor: ");
	
	scanf("%d", &a);
	
	return a;
}

int main( ) {
	int *a;
	
	a = (int *) malloc(sizeof(int));
	
	*a = ler();
	
	printf("Valor: %d", *a);
	
	return 0;
}