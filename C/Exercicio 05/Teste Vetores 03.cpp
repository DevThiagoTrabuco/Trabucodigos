/*Crie uma matriz 4X3. Adicione, informações em seus valores. Depois, mostre
qual é o elemento armazenado em uma linha e coluna X solicitado pelo usuário.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	int main(){
		int a[4][3], line, column;
		
		for(int l = 0;l < 4;l++){
			for(int c = 0;c < 3;c++){
				scanf(" %d", &a[l][c]);
			}
		}
		system("cls");
		
		printf("Linha: ");
		scanf(" %d", &line);
		printf("Coluna: ");
		scanf(" %d", &column);
		
		system("cls");
		
		if(line >= 0 && line < 4 && column >= 0 && column < 3){
			printf("%d", a[line][column]);
		}
		else{
			printf("Linha ou coluna invalida");
		}
	}