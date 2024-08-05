/*Escreva um programa que leia do teclado as duas notas de um aluno, calcule e exiba a média 
aritmética das notas. O programa deve, adicionalmente, exibir a mensagem de resultado se o 
aluno está aprovado (média superior ou igual a 7,0), em recuperação (média superior ou 
igual a 5,0 e inferior a 7,0) ou reprovado (média inferior a 5,0).*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<locale.h>

	int main(){
	
		setlocale(LC_ALL, "portuguese");
		char name[10];
		float g1, g2, avrg;
		
		printf("Escreva seu nome:\n");
		scanf("%s", name);
		printf("Informe a primeira nota:\n");
		scanf("%f", &g1);
		printf("Informe a segunda nota:\n");
		scanf("%f", &g2);
		
		avrg = (g1 + g2)/2;
		
		if(avrg >= 7){
			printf("Nota: %.2f\nParabéns, você foi APROVADO!", avrg);
		}
		else if(avrg >= 5 && avrg < 7){
			printf("Nota: %.2f\nRECUPERAÇÃO", avrg);
		}
		else{
			printf("Nota: %.2f\nREPROVADO", avrg);
		}
	}