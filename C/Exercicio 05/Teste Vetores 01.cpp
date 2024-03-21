/*Escreva um algoritmo para receber dez nomes, armazena-los em um vetor e
em seguida exibi-los*/
#include<stdio.h>
#include<string.h>
#include<stdlib.h>

	int main(){
		char v[3][10];
		
		for(int i = 0;i < 3;i++){
			printf("Escreva um nome %d ", i + 1);
			scanf(" %s", &v[i]);
		}
			system("cls");
		for(int i = 0;i < 3;i++){
			printf("%s\n", v[i]);
		}
	}