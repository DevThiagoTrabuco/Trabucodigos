/*Para os exerc�cios abaixo, substitua as vari�veis do tipo int, double, char e float por aloca��o din�mica. Se
houver ponteiros no c�digo, mantenha-os.*/
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
