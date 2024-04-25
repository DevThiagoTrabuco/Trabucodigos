#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<conio.h>

	float exibit(float grd1, float grd2, float grd3, char op){
		float result;
		switch(op){
			case 1: 
				result = (grd1 + grd2 + grd3) / 3;
				break;
			case 2:
				result = ((grd1 * 5) + (grd2 * 3) + (grd3 * 2))/10;
				break;
		}
		return result;
	}

	int main(){
		char name[10];
		int op;
		float grd1, grd2, grd3;

			printf("Informe o nome do aluno: ");
			scanf(" %s", &name);
					
			printf("Informe a nota 1: ");
			scanf(" %f", &grd1);
			printf("Informe a nota 2: ");
			scanf(" %f", &grd2);
			printf("Informe a nota 3: ");
			scanf(" %f", &grd3);
						
			printf("Escolha uma opcao: ");
			printf("\n1 - MEDIA ARITMETICA");
			printf("\n2 - MEDIA PONDERADA");
			printf("\n0 - SAIR\n");
			scanf(" %d", &op);
			
			system("cls");
			
			if(op == 0){
				abort;
			}
			else{
			float result = exibit(grd1, grd2, grd3, op);
			printf("Media: %.2f", result);
			}
	}
	
