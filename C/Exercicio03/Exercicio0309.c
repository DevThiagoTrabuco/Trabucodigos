/*Elabore um algoritmo que, dada a idade de um nadador. Classifique-o em uma das seguintes 
categorias:
Infantil A = 5 – 7 anos
Infantil B = 8 – 10 anos
Juvenil A = 11 – 13 anos
Juvenil B = 14 – 17 anos
Sênior = 18 – 25 anos
Apresentar mensagem “idade fora da faixa etária” quando for outro ano não contemplado.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>


	int main(){
		char name[10];
		int age;
		
		printf("Informe seu nome: ");
		scanf("%s", name);
		printf("Informe sua idade: ");
		scanf("%d", &age);
		fflush(stdin);
		
		if(age >= 5 && age <= 7){
			printf("Categoria Infantil A");
		}
		else if(age >= 8 && age <= 10){
			printf("Categoria Infantil B");
		}
		else if(age >= 11 && age <= 13){
			printf("Categoria Juvenil A");
		}
		else if(age >= 14 && age <= 17){
			printf("Categoria Juvenil B");
		}
		else if(age >= 18 && age <= 25){
			printf("Senior");
		}
		else{
			printf("Idade fora de faixa etária.");
		}
	}