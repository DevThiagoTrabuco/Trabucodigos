/*Escreva um programa que leia do teclado as duas notas de um aluno, calcule e exiba a m�dia
aritm�tica das notas. O programa deve, adicionalmente, exibir uma mensagem de parab�ns
caso o aluno esteja aprovado (m�dia superior ou igual a 5,0)*/
#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<string.h>
#include<ctype.h>
#include<locale.h>
	int main(){
		setlocale(LC_ALL, "portuguese");
		float g1, g2, avrg;
		char name[50];
		
		printf("Informe o seu nome: ");
		scanf("%s", name);
		
		printf("Forne�a a primeira nota: ");
		scanf("%f", &g1);
		fflush(stdin);
		printf("Forne�a a segunda nota: ");
		scanf("%f", &g2);
		
		avrg = (g1 + g2)/2;
		
		if(avrg >= 5.0){
			printf("Parab�ns, voc� foi aprovado!\nNota: %.2f", avrg);
		}
		else if(avrg < 5.0){
			printf("Que pena, voc� foi reprovado.\nNota: %.2f", avrg);
		}
	}