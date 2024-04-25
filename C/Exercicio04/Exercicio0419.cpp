/*Foi realizada uma pesquisa de algumas características físicas da população de uma certa 
região, a qual coletou os seguintes dados referentes a cada habitante para serem analisados: 
 - sexo (masculino e feminino)
 - cor dos olhos (azuis, verdes ou castanhos)
 - cor dos cabelos ( louros, castanhos, pretos)
 - idade 
 Faça um algoritmo que determine e escreva: 
 - a maior idade dos habitantes
 - a quantidade de indivíduos do sexo feminino cuja idade está entre 18 e 35 anos inclusive e que 
tenham olhos verdes e cabelos louros.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	int main(){
		char exit = '1';
		char hair[10], eyes[10], sex;
		int age = 0, i = 1, olderAge = 0, cont = 0;
		
		while(exit != '0'){
			printf("Informe seu sexo(M / F): ");
			scanf(" %c", &sex);
			printf("Informe sua idade: ");
			scanf(" %d", &age);
			printf("Cor do cabelo: ");
			scanf(" %s", &hair);
			printf("Cor dos olhos: ");
			scanf(" %s", &eyes);
			
			if(age > olderAge){
				olderAge = age;
			}
			
			if(sex == 'F'
			&& strcmp(eyes, "verdes") == 0
			&& strcmp(hair, "loiro") == 0
			&& age >=18 && age < 35){
				cont++;
			}
			
			i++;
			system("cls");
			printf("Deseja sair? (1 - Continuar / 0 - Sair)\n");
			scanf(" %c", &exit);
			system("cls");
		}
		system("cls");
		printf("Maior idade: %d", olderAge);
		printf("\nMulheres entre 18 e 35 anos, loiras de olhos verdes: %d", cont);
	}