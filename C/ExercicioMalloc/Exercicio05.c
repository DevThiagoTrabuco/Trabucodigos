//Algoritmo com função 1:
#include<stdio.h>
#include<stdlib.h>

void apresentar(int b) {
	printf("Valor: %d",b);
}

int main( ) {
	int *a;
	
	a = (int *) malloc(sizeof(int));
	
	*a = 4;
	
	apresentar(*a);
	
	return 0;
}