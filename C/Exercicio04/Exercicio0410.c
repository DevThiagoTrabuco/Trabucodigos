/*Construa uma calculadora que permita realizar somas, subtrações, multiplicações e divisões. 
Considere que o usuário pode acumular resultados, como em uma calculadora normal.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<conio.h>

	int calculator(int n1, char op, int n2){
		int n3;
		
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
				printf("Operacao invalida");
				break;
		}
		return (n3);
	}
	
	int main(){
		char op;
		int n1, n2, n3;
		
		printf("Forneca um numero A: ");
		scanf("%d", &n1);
		
		fflush(stdin);
		
		printf("Escolha uma operacao:");
		printf("\n+ --> Soma");
		printf("\n- --> Subtracao");
		printf("\n* --> Multiplicacao");
		printf("\n/ --> Divisao\n");
		scanf("%c", &op);
		
		printf("Forneca um numero B: ");
		scanf("%d", &n2);		
		
		n3 = calculator(n1, op, n2);
		
		printf("Resultado:");
		printf("\n%d", n3);
		
		while(1){
			fflush(stdin);
			printf("\nEscolha uma operacao: ");
			scanf("%c", &op);
			printf("Forneca um numero: ");
			scanf("%d", &n2);
			
			n3 = calculator(n3, op, n2);
			
			printf("Resultado:");
			printf("\n%d", n3);
		}
	} 