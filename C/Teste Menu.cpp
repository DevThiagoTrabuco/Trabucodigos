#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
	
	void q1(), q2(), q3(), q4(), q5(), sleep();
	
	int main(){
		setlocale(LC_ALL, "portuguese");
		int op;
		
		do{
			printf("\t\t\t## EXERCÍCIOS - ANEXO 08##\n\n");
			
			printf("1 - EXERCÍCIO 01\n");
			printf("2 - EXERCÍCIO 02\n");
			printf("3 - EXERCÍCIO 03\n");
			printf("4 - EXERCÍCIO 04\n");
			printf("5 - EXERCÍCIO 05\n");
			printf("0 - SAIR\n");
			printf("ESCOLHA: ");
			scanf(" %d", &op);
			
			system("cls");
			
			switch(op){
				case 1:
					q1();
					sleep();
					break;
				case 2:
					q2();
					sleep();
					break;
				case 3:
					q3();
					sleep();
					break;
				case 4:
					q4();
					sleep();
					break;
				case 5:
					q5();
					sleep();
					break;
				case 0:
					printf("ADEUS :[");
					sleep();
					abort;
					break;
				default:
					printf("OPÇÃO INVÁLIDA\n");
					system("cls");
			}
		} while (op != 0);
	}
	
	void q1(){
		int years = 0;
		float juca = 1.10, chico = 1.50;
		
		while(juca <= chico){
			_sleep(150);
			printf("Juca: %f   Chico: %f\n", juca, chico);
			juca += 0.03;
			chico += 0.02;
			++years;
		}
		printf("Juca vai alcanÃ§ar Chico em %d anos\n", years);
	}
	void q2(){
		int num, res, cont = 0;
		
		printf("Informe um numero para ver a sua tabuada: ");
		scanf("%d", &num);
		
		for(cont = 0;cont <= 10; cont++){
			res = num * cont;
			_sleep(150);
			printf("%d * %d = %d\n", num, cont, res);
		}
	}
	void q3(){
		int num;
		
		for(int i = 0;i < 5;i++){
			printf("Informe um numero: ");
			scanf("%d", &num);
		
			if(num < 0){
				printf("Este numero eh negativo.\n");
			}
			else if(num > 0){
				printf("Este numero eh positivo.\n");
			}
			if(num == 0){
				printf("Este numero eh zero.\n");
			}
		}
	}
	void q4(){
		for(int num = 1000;num <= 1999;num++){
			if(num % 11 == 5){
				_sleep(100);
				printf("%d\n", num);
			}
		}
	}
	void q5(){
		int num, sum = 0, cont = 0;
		float avrg;
		
		do{
			printf("Informe um numero: ");
			scanf("%d", &num);
			if(num % 2 == 0 && num != 0){
				cont++;
				sum += num;
			}
		}
		while(num != 0);
		avrg = sum / cont;
		printf("Media: %.1f", avrg);
	}
	void sleep(){
		_sleep(500);
		system("cls");
	}
