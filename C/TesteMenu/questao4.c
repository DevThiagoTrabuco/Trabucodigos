#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<conio.h>

	bool posNeg(int num){
		bool t = true;
		if (num < 0){
			t = false;
		}
		return t;
	}
	
	void q4(){
		int num;
		bool a;
		
		printf("Informe um valor: ");
		scanf(" %d", &num);
		
		a = posNeg(num);
		
		if(a == true){
			printf("O valor %d eh positivo", num);
		}
		else{
			printf("O valor %d eh negativo", num);
		}
	}
