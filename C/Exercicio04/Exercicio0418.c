/*Em uma eleição presidencial existem quatro candidatos. Os votos são informados através de 
códigos. Os dados utilizados para a contagem dos votos obedecem à seguinte codificação: 
 - 1,2,3,4 = voto para os respectivos candidatos;
 - 5 = voto nulo;
 - 6 = voto em branco;
 Elabore um algoritmo que leia o código do candidato em um voto. Calcule e escreva:
 - total de votos para cada candidato;
 - total de votos nulos;
 - total de votos em branco*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	int main(){
		int sumVote = 0, c1 = 0, c2 = 0, c3 = 0;
		int c4 = 0, null = 0, clean = 0, vote;
		
		do{
			printf("###ELEICOES###");
			printf("\nEscolha seu voto:");
			printf("\n1 - CANDIDATO 1;");
			printf("\n2 - CANDIDATO 2;");
			printf("\n3 - CANDIDATO 3;");
			printf("\n4 - CANDIDATO 4;");
			printf("\n5 - NULO;");
			printf("\n6 - BRANCO;");
			printf("\n7 - ENCERRAR.\n");
			scanf(" %d", &vote);
			switch(vote){
				case 1:
					sumVote++;
					c1++;
					system("cls");
					break;
				case 2:
					sumVote++;
					c2++;
					system("cls");
					break;
				case 3:
					sumVote++;
					c3++;
					system("cls");
					break;
				case 4:
					sumVote++;
					c4++;
					system("cls");
					break;
				case 5:
					sumVote++;
					null++;
					system("cls");
					break;
				case 6:
					sumVote++;
					clean++;
					system("cls");
					break;
				case 7:
					system("cls");
					printf("VOTACAO ENCERRADA.");
					break;
				default:
					printf("OPERACAO INVALIDA");
					scanf(" %d", vote);
			}
		}
		while(vote != 7);
		
		printf("\n###RESULTADOS###");
		printf("\nCANDIDATO 1: %d", c1);
		printf("\nCANDIDATO 2: %d", c2);
		printf("\nCANDIDATO 3: %d", c3);
		printf("\nCANDIDATO 4: %d", c4);
		printf("\nNULO: %d", null);
		printf("\nBRANCO: %d", clean);
		printf("\nTOTAL DE VOTOS: %d", sumVote);
	}