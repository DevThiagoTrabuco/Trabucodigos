/*Crie uma STRUCT chamada Retangulo com os campos largura e altura. Em seguida, escreva
um programa em C que calcule e exiba a área de um retângulo com base nos valores
fornecidos pelo usuário.*/
#include<stdio.h>
#include<string.h>
#include<locale.h>
#include<stdlib.h>

typedef struct {
	float base;
	float height;
	float area;
} Area;

Area rectangle;

int main(){
	while(1){
		printf("Valor da base: ");
		scanf(" %f", &rectangle.base);
		printf("Valor da altura: ");
		scanf(" %f", &rectangle.height);
		
		rectangle.area = rectangle.base * rectangle.height;
		
		printf("Area: %.2f\n", rectangle.area);
		system("pause");
		system("cls");
	}
}