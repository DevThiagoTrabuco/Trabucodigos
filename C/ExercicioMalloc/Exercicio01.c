/*Para os exercícios abaixo, substitua as variáveis do tipo int, double, char e float por alocação dinâmica. Se
houver ponteiros no código, mantenha-os.*/
#include<stdio.h>
#include<stdlib.h>

//Algoritmo simples 1:
int main( ) {
	int *a;
	
	a = (int *) malloc(sizeof(int));
	
	*a = 3;
	
	printf("Valor: %d", *a);
	
	return 0;
}
