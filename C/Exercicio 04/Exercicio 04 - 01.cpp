/*Chico tem 1,50m e cresce 2 centímetros por ano, enquanto Juca tem 1,10m e cresce 3 
centímetros por ano. Construir um algoritmo que calcule e imprima quantos anos serão 
necessários para que Juca seja maior que Chico.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>

	int main(){
		int years = 0;
		float juca = 1.10, chico = 1.50;
		
		while(juca <= chico){
			_sleep(250);
			printf("Juca: %f   Chico: %f\n", juca, chico);
			juca += 0.03;
			chico += 0.02;
			++years;
		}
		printf("Juca vai alcançar Chico em %d anos", years);
	}