/*Calcular a média das 4 notas de 5 alunos e apresentar quem foi aprovado ou
reprovado*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	int main(){
		int nm = 5, grd = 4;
		char name[nm][10];
		float grade[nm][grd], sumGrade = 0, avrgGrade;
		
		for(int i = 0;i < nm;i++){
			printf("Aluno %d: ", i + 1);
			scanf(" %s", &name[i]);
			for(int x = 0;x < grd;x++){
				printf("Nota %d: ", x + 1);
				scanf(" %f", &grade[i][x]);
				sumGrade += grade[i][x];
				avrgGrade = sumGrade / grd;
			}
			if(avrgGrade >= 7){
				printf("%s : APROVADO", name[i]);
				printf("\nMedia: %.2f", avrgGrade);
			}
			else{
				printf("%s : REPROVADO", name[i]);
				printf("\nMedia: %.2f", avrgGrade);
			}
			_sleep(1000);
			system("cls");
		}	
	}