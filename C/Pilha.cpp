#include<stdio.h>
#include<stdlib.h>
#include<locale.h>

#define TAM 10

//Struct da pilha
typedef struct {
	int item[TAM];
	int top;
} Pile;

void start(Pile *p){
	p->top = -1; //inicializa a pilha
}
int isEmpty(Pile *p){
	if(p->top == -1)	return 1;
	return 0;
	//return p->top == 1 ? 1 : 0; //Operador ternário
}
int isFull(Pile *p){
	if(p->top == TAM - 1)	return 1;
	return 0;
	//return p->top == TAM - 1 ? 1 : 0; //Operador ternário
}
void push(Pile *p, int num){
	if(isFull(p) == 1){
		system("cls");
		printf("Pilha está cheia");
		system("pause");
		return;
	} else {
		p->top++;
		p->item[p->top] = num;
		printf("%d foi inserido na pilha\n", num);
		system("pause");
		system("cls");
	}
}
void pop(Pile *p){
	if(isEmpty(p)){
		system("cls");
		printf("A pilha está vazia");
		system("pause");
		return;
	} else {
		int aux = p->item[p->top];
		p->item[p->top] = NULL;
		p->top--;
		printf("%d foi removido da pilha\n", aux);
		system("pause");
		system("cls");
	}
}
void control(Pile *p, int op){
	int num;
	switch(op){
		case 1:
			printf("Informe um número: ");
			scanf(" %d", &num);
			push(p, num);
			system("pause");
			system("cls");
			break;
		case 2:
			pop(p);
			system("pause");
			system("cls");
			break;			
		case 3:
			if(isEmpty(p)) printf("A pilha está vazia.\n");
			else printf("A pilha não está vazia.\n");
			system("pause");
			system("cls");
			break;
		case 4:
			if(isFull(p)) printf("A pilha está cheia.\n");
			else printf("A pilha não está cheia.\n");
			system("pause");
			system("cls");
			break;
		case 5:
			printf("Tamanho da pilha: %d\n", p->top + 1);//size(p)
			system("pause");
			system("cls");
			break;
		case 6:
			printf("%d\n", p->item[p->top]);//peek(p)
			system("pause");
			system("cls");
		case 7:
			abort;
		default:
			break;
	}
}
void menu(){
	printf("1 - INSERIR NA PILHA");
	printf("\n2 - REMOVER DA PILHA");
	printf("\n3 - VERIFICAR SE LISTA ESTÁ CHEIA");
	printf("\n4 - VERIFICAR SE LISTA ESTÁ VAZIA");
	printf("\n5 - TAMANHO DA PILHA");
	printf("\n6 - TOPO DA PILHA");
	printf("\n7 - SAIR");
	printf("\nEscolha uma opção: ");
}
int main(){
	int op;
	setlocale(LC_ALL, "");
	Pile *p = (Pile *) malloc(sizeof(Pile));
	
	start(p);
	while(op != 7){
		menu();
		scanf(" %d", &op);
		system("cls");
		control(p, op);
	}
}