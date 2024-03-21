#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>
#include<conio.h>

	void load(){
		char wrd[] = "C A R R E G A N D O. . .";
		int size = strlen(wrd);
		
		for(int i = 0;i < size;i++){
			_sleep(250);
			printf("%c", wrd[i]);
		}
		
		system("cls");
	}