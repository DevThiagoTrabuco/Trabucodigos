/*Crie um algoritmo que peça ao usuário que informe oito números inteiros 
e os armazene-os em um vetor. Apresente o maior elemento e a posição 
em que ele se encontra no vetor.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	int main(){
		int v[8], hghst, pstn;
		
		for(int i = 0;i < 8; i++){
			printf("Forneca um numero %d: ", (i + 1));
			scanf(" %d", &v[i]);
		}
		hghst = v[1];
		pstn = v[1];
		
		for(int i = 0;i < 8; i++){
			if(v[i] > hghst){
				hghst = v[i];
				pstn = i;
			}
		}
		system("cls");
		printf("O maior valor do vetor eh %d, que esta na posicao %d do vetor", hghst, pstn);
	}