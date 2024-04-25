//Algoritmo simples 2:
#include<stdio.h>
#include<stdlib.h>

int main( ) {
	double *x;
	
	x = (double *) malloc(sizeof(double));
	*x = 3.2;
	
	printf("Valor: %.1lf", *x);
	return 0;
}

