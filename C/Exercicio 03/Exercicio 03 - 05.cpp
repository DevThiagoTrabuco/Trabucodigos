/*. Faça um programa que leia um código de operação (+, -, * ou /), e também dois valores inteiros 
A e B. O programa deve calcular o resultado da operação escolhida aplicado a A e B. Por 
exemplo, se a operação escolhida foi * e A = 1 e B = 3, o programa deve fornecer como 
resultado o valor de 1*3, que é 3.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<locale.h>
	int main(){
		setlocale(LC_ALL, "portuguese");
		char op;
		int n1, n2, n3;
		
		printf("Forneça um número A: ");
		scanf("%d", &n1);
		printf("Forneça um número B: ");
		scanf("%d", &n2);		
		
		fflush(stdin);
		
		printf("Escolha uma operação:");
		printf("\n+ --> Soma");
		printf("\n- --> Subtração");
		printf("\n* --> Multiplicação");
		printf("\n/ --> Divisão\n");
		scanf("%c", &op);
		
		switch(op){
			case '+':
				n3 = n1 + n2;
				break;
			case '-':
				n3 = n1 - n2;
				break;
			case '*':
				n3 = n1 * n2;
				break;
			case '/':
				n3 = n1 / n2;
				break;
			default:
				printf("Operação inválida");
				break;
		}
		printf("Resultado:");
		printf("\n%d %c %d = %d", n1, op, n2, n3);
	}