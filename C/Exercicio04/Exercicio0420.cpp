/*Foi feita uma pesquisa entre os habitantes de uma região. Foram coletados os dados de idade, 
sexo (M/F) e salário. Faça um algoritmo que informe: 
 a) a média de salário do grupo;
 b) maior e menor idade do grupo;
 c) quantidade de homens com salário até R$1000,00.*/
 #include<stdio.h>
 #include<stdlib.h>
 #include<string.h>
 
 	int main(){
 		char exit = '1', sex;
 		int age, i = 1, cont = 0, older = 0, youngest = 999;
 		float salary, sumSalary = 0, avrgSalary = 0;
 		
 		while(exit != '0'){
			printf("Sexo(M / F) - habitante %d: ", i);
			scanf(" %c", &sex);
			printf("Idade - habitante %d: ", i);
			scanf(" %d", &age);
			printf("Salario - habitante %d: ", i);
			scanf(" %f", &salary);
			
			sumSalary += salary;
			
			if(age > older){
				older = age;
			}
			if(age < youngest){
				youngest = age;
			}
			if(sex == 'M' && salary < 1001){
				cont++;
			}
			avrgSalary = sumSalary / i;
			
			system("cls");
			printf("Deseja sair? (1 - Continuar / 0 - Sair)\n");
			scanf(" %c", &exit);
			system("cls");
	 	}
	 	
	 	printf("Media salarial: %.2f", avrgSalary);
	 	printf("\nMaior idade: %d", older);
	 	printf("\nMenor idade: %d", youngest);
	 	printf("\nHomens mal pagos: %d", cont);
	}