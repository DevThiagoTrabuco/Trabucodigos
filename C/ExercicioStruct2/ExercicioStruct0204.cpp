/*Crie uma STRUCT chamada Data com os campos dia, mes e ano. Escreva um programa em C
que solicita ao usuário que insira duas datas e determine qual delas ocorreu primeiro.*/
#include<stdio.h>
#include<string.h>
#include<locale.h>
#include<stdlib.h>

typedef struct {
	int day;
	int month;
	int year;
} Date;

Date date1, date2;

	int main(){
		setlocale(LC_ALL, "");
		
		printf("Primeira data(dd mm aaaa): ");
		scanf(" %d %d %d", &date1.day, &date1.month, &date1.year);
		printf("Segunda data(dd mm aaaa): ");
		scanf(" %d %d %d", &date2.day, &date2.month, &date2.year);
		
		if (date1.year < date2.year) printf("A primeira data ocorreu primeiro.");
		else if (date2.year < date1.year) printf("A segunda data ocorreu primeiro.");
		else {
			if (date1.month < date2.month) printf("A primeira data ocorreu primeiro."); 
			else if (date2.month < date1.month)	printf("A segunda data ocorreu primeiro.");
			 else {
				if (date1.day < date2.day) printf("A primeira data ocorreu primeiro.");
				else if (date2.day < date1.day)	printf("A segunda data ocorreu primeiro.");
				else printf("As duas datas são iguais.");
			}
		}
	}