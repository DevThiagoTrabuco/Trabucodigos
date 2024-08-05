//Algoritmo simples 3:
#include<stdio.h>
#include<stdlib.h>

int main( ) {
	char *z;
	
	z = (char *) malloc(sizeof(char)+1);
		
	*z = 'a';
	
	printf("Valor: %c", *z);
	
	return 0;
}