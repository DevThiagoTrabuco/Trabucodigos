#include<stdio.h>
#include<conio.h>

void increase(int *num){
	*num += 1;
}

int main(){
	int A = 10, **B, *C;
	
	C = &A;
	
	B = &C;
	
	printf("A atraves de A: %d\n", A);
	printf("A atraves de C: %d\n", *C);
	printf("A atraves de B: %d\n\n", **B);
	
	int i = 5, *p;
	p = &i;
	printf("%d, %d, %d, %d, %d\n\n", p, (*p + 2), **&p, (3**p), (**&p + 4));
	
	int num = 100;
	int *ptr = &num;
	printf("Numero: %d\n", num);
	/*printf("Incrementando...\n");
	increase(&num);
	printf("Numero: %d\n", num);*/
	printf("Endereco do numero: %x\n", &num);
	printf("Conteudo do ponteiro: %x\n", ptr);
	printf("Numero atraves do ponteiro: %d\n", *ptr);
}