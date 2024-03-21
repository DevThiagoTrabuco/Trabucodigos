/*Desenvolver um algoritmo que leia a altura de 15 pessoas. Este programa deverá calcular e
 mostrar:
 a. A menor altura do grupo;
 b. A maior altura do grupo;*/
 #include<stdio.h>
 #include<stdlib.h>
 #include<string.h>
 
 	int main(){
 		float hght = 0, hghst = 0, shrtr = 0;
 		
 		printf("Forneca uma altura: ");
 		scanf("%f", &hght);
 		
 		hghst = hght;
 		shrtr = hght;
 		
 		for(int i = 0;i < 4;i++){
	 		printf("Forneca uma altura: ");
	 		scanf("%f", &hght);
	 		
	 		if(hght > hghst){
	 			hghst = hght;
			}
			if(hght < shrtr){
				shrtr = hght;
			}
		}
		printf("Maior altura: %.1f", hghst);
		printf("\nMenor altura: %.f", shrtr);
	}