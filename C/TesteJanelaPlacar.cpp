#include<stdio.h>
#include<windows.h>//biblioteca para alteração da janela

int main(){
	
	int score1 = 0, score2= 0;
	
	SMALL_RECT windowSize{0, 0, 60, 20};//altera o tamanho da janela(valores iguais geralmente ñ funfam)
	SetConsoleWindowInfo(GetStdHandle(STD_OUTPUT_HANDLE), TRUE, &windowSize);
	
	for(int i = 1;i < 5;i++){//placar de jogadores (tá num for só para eu testar a alteração na pontuação independente)
		printf("J1: %d", score1);
		printf("\t\t\t\t\t\t\tJ2: %d", score2);
		score1++;
		_sleep(500);
		system("cls");
	}
		
	
}