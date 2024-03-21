#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<stdbool.h>

	bool parImpar(int num){
		bool t = true;
		if (num % 2 == 1){
			t = false;
		}
		return t;
	}
	
	int main(){
		int num;
		bool a;
		
		printf("Informe um valor: ");
		scanf(" %d", &num);
		
		a = parImpar(num);
		
		if(a == true){
			printf("O valor %d eh par", num);
		}
		else{
			printf("O valor %d eh impar", num);
		}
	}
