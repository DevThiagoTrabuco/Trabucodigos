/*Construa um algoritmo para determinar o IMC (Índice de Massa Corpórea) do indivíduo que é 
definida como sendo a relação entre o peso (PESO) e o quadrado da Altura (ALTURA) do 
indivíduo. O programa deve verificar e imprimir em tela a condição e situação do IMC 
encontrado*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<locale.h>
#include<math.h>

	int main(){
		setlocale(LC_ALL, "portuguese");
		char name[10];
		float hght, wght, CMI;
		
		printf("Informe seu nome: ");
		scanf("%s", name);
		printf("Informe seu peso: ");
		scanf("%f", &wght);
		fflush(stdin);
		printf("Informe sua altura: ");
		scanf("%f", &hght);
		
		CMI = wght / (hght * hght);
		
		if(CMI < 20){
			printf("IMC: %.3f\nSua situação é: Abaixo do peso.", CMI);
		}
		else if(CMI >= 20 && CMI < 25){
			printf("IMC: %.3f\nSua situação é: Normal.", CMI);
		}
		else if(CMI >= 25 && CMI < 30){
			printf("IMC: %.3f\nSua situação é: Sobrepeso.", CMI);
		}
		else if(CMI >= 30 && CMI < 40){
			printf("IMC: %.3f\nSua situação é: Obeso(a).", CMI);
		}
		else{
			printf("IMC: %.3f\nSua situação é: Obesidade mórbida.", CMI);
		}
	}