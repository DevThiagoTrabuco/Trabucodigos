#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<conio.h>

	void gamePrd(int strtH, int strtM, int endH, int endM, int* prdH, int* prdM){
		if(endH < strtH || (endH == strtH && endM < strtM)){
			endH += 24;
		}
		int strt = strtH * 60 + strtM;
		int end = endH * 60 + endM;
		int prd = end - strt;
		*prdH = prd / 60;
		*prdM = prd % 60;
	}
	
	void q6(){
		int strtH, strtM, endH, endM;
		int prdH, prdM;
		
		printf("Inicio da partida(Horas): ");
		scanf(" %d", &strtH);
		printf("Inicio da partida(Minutos): ");
		scanf(" %d", &strtM);
		printf("Termino da partida: ");
		scanf(" %d", &endH);
		printf("Termino da partida: ");
		scanf(" %d", &endM);
		
		gamePrd(strtH, strtM, endH, endM, &prdH, &prdM);
		
		printf("A duracao da partida eh de %d horas e %d minutos.\n", prdH, prdM);
	}