//Algoritmo com função 4:
#include<stdio.h>
#include<stdlib.h>

int calcular(int a){
	a = a*2;
	
	return a;
}

int main( ) {
	int *a;
	int *dobro;
	
	a = (int *) malloc(sizeof(int));
	dobro = (int *) malloc(sizeof(int));
	
	*a = 3;
	
	*dobro = calcular(*a);
	
	printf("Valor: %d %d", *a, *dobro);
	
	return 0;
}