/*Defina uma estrutura Funcionario com os campos nome, idade, cargo e salario. Crie um
programa que leia os dados de cinco funcionários, armazene-os em um vetor de estruturas
e, em seguida, calcule e exiba a média dos salários desses funcionários.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	struct Employee{
		char name[50], office[20];
		int age;
		float slr;
	};
	
	int main(){
		struct Employee workForce[5];
		float sumSlr = 0, avrgSlr = 0;
		
		for(int i = 0;i < 5;i++){
			fflush(stdin);
			printf("Nome funcionario %d: ", i + 1);
			gets(workForce[i].name);
			printf("Idade funcionario %d: ", i + 1);
			scanf(" %d", &workForce[i].age);
			fflush(stdin);
			printf("Cargo funcionario %d: ", i + 1);
			gets(workForce[i].office);
			printf("Salario funcionario %d: ", i + 1);
			scanf(" %f", &workForce[i].slr);
			
			sumSlr += workForce[i].slr;
			system("cls");
		}
		
		avrgSlr = sumSlr / 5;
		
		system("cls");
		
		for(int i = 0;i < 5;i++){
			printf("FUNCIONARIO %d", i + 1);
			printf("\nNome: %s", workForce[i].name);
			printf("\nIdade: %d", workForce[i].age);
			printf("\nCargo: %d", workForce[i].office);
			printf("\nSalario: %.2f\n\n", workForce[i].slr);
		}
		
		printf("Media Salarial: %.2f", avrgSlr);
	}