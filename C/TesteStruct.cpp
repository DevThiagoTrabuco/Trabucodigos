#include<stdio.h>
#include<stdlib.h>
#include<string.h>


	struct StudentFile {
		char name[50];
		char _class[30];
		float grd1;
		float grd2;
	};
	
	int main(){
		struct StudentFile file1, file2;
		
		strcpy(file1.name, "Corlos");
		strcpy(file1._class, "LP");
		file1.grd1 = 8.5;
		file1.grd2 = 6.2;
		printf("ALUNO 1");
		printf("\n%s", file1.name);
		printf("\n%s", file1._class);
		printf("\n%.2f", file1.grd1);
		printf("\n%.2f", file1.grd2);
		
		printf("\n\nInforme no nome do aluno 2: ");
		gets(file2.name);
		printf("Informe a disciplina: ");
		gets(file2._class);
		printf("Nota 1: ");
		scanf(" %f", &file2.grd1);
		printf("Nota 2: ");
		scanf(" &f", &file2.grd2);
		
		printf("\nALUNO 2");
		printf("\n%s", file2.name);
		printf("\n%s", file2._class);
		printf("\n%.2f", file2.grd1);
		printf("\n%.2f", file2.grd2);
	}