#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<conio.h>

	int birthday(int yrs, int mnths, int day){
		int days;
		days = ((yrs * 365) + (mnths * 30) + day);
	}
	
	void q3(){
		int yrs, mnths, day, days;
		
		printf("Informe quantos anos voce tem de vida: ");
		scanf(" %d", &yrs);
		printf("Informe quantos meses voce tem de vida: ");
		scanf(" %d", &mnths);
		printf("Informe quantos dias voce tem de vida: ");
		scanf(" %d", &day);
		
		system("cls");
		days = birthday(yrs, mnths, day);
		
		printf("Voce tem aproximadamente %d dias de vida", days);
	}
