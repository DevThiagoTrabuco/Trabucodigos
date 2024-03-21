#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
#include <ctype.h>

#include "questao1.cpp"
#include "questao2.cpp"
#include "questao3.cpp"
#include "questao4.cpp"
#include "questao5.cpp"
#include "questao6.cpp"
#include "loadingScreen.cpp"

	
	
	int main(){
		setlocale(LC_ALL, "portuguese");
		int op;
		
		do{
			printf("\t\t\t## EXERC�CIOS - FIXA��O ##\n\n");
			
			printf("1 - EXERC�CIO 01\n");
			printf("2 - EXERC�CIO 02\n");
			printf("3 - EXERC�CIO 03\n");
			printf("4 - EXERC�CIO 04\n");
			printf("5 - EXERC�CIO 05\n");
			printf("6 - EXERC�CIO 06\n");
			printf("0 - SAIR\n");
			printf("ESCOLHA: ");
			scanf(" %d", &op);
			
			system("cls");
			
			switch(op){
				case 1:
					load();
					q1();
					_sleep(2000);
					system("cls");
					break;
				case 2:
					load();
					q2();
					_sleep(2000);
					system("cls");
					break;
				case 3:
					load();
					q3();
					_sleep(2000);
					system("cls");
					break;
				case 4:
					load();
					q4();
					_sleep(2000);
					system("cls");
					break;
				case 5:
					load();
					q5();
					_sleep(2000);
					system("cls");
					break;
				case 6:
					load();
					q6();
					_sleep(2000);
					system("cls");
					break;
				case 0:
					printf("ADEUS :[");
					abort;
					break;
				default:
					printf("OP��O INV�LIDA\n");
					_sleep(500);
					system("cls");
			}
		} while (op != 0);
	}