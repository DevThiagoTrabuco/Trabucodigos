/*A prefeitura de uma cidade precisa fazer uma pesquisa entre seus habitantes, coletando dados 
sobre o salário e número de filhos. A prefeitura deseja saber: 
 a) média do salário da população;
 b) média do número de filhos;
 c) maior salário;
 d) percentual de pessoas com salário até R$1000,00.
 Desenvolva um algoritmo para auxiliar nessa tarefa*/
 #include<stdio.h>
 #include<stdlib.h>
 #include<string.h>
 
 	int main(){
 		char stop;
 		int children, sumChildren = 0, lowSlry = 0, i = 1;
 		float salary, sumSalary = 0, avrgSlry, avrgChildren;
 		float hghstSlry, percentage;
 		
 		do{
 			printf("Informe o salario do habitante %d: ", i);
 			scanf(" %f", &salary);
 			printf("Informe a quantidade de filhos do habitante %d: ", i);
 			scanf(" %d", &children);
 			
 			sumSalary += salary;
 			sumChildren += children;
 			hghstSlry = salary;
 			
			if(salary > hghstSlry){
				hghstSlry = salary;
			}
			if(salary < 1001){
				lowSlry++;
			}
			i++;
			avrgSlry = sumSalary / (i - 1);
			avrgChildren = sumChildren / (i - 1);
			percentage = (lowSlry / (i - 1)) *100;
			
			printf("Deseja parar?(s/n): ");
			scanf(" %c", &stop);
		 }
		 while(stop != 's');
		 
		 printf("Media de salarios: %.2f", avrgSlry);
		 printf("\nMedia de filhos: %.2f", avrgChildren);
		 printf("\nMaior salario: %.2f", hghstSlry);
		 printf("\nPercentual de pessoas mal-pagas: %.2f %%", percentage);
	}