#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>
#include<locale.h>

#define PRDCT_NMBR 30
#define PRDCT_DATA 50

typedef struct{
	float prdctPrice;
	int prdctQtt, prdctCode;
	char prdctName[PRDCT_DATA];
} STOCK;

STOCK product[PRDCT_NMBR];
int op, prdctNum, sortNum, i = 0;

bool fullList(){
	if (i == PRDCT_NMBR){
		return true;
	}
	return false;
}

bool emptyList(){
	if(i == 0){
		return true;
	}
	return false;
}

void prdctRegister(){
	srand(time(NULL));	
	if(fullList()){
		system("cls");
		printf("\t###LISTA DE PRODUTOS CHEIA###\n\n");
		system("pause");
		system("cls");
	} else {
		system("cls");
		printf("\t###CADASTRAR PRODUTOS###\n\n");
		printf("Nome do produto: ");
		gets(product[i].prdctName);
		sortNum = rand() % 1000000;
		product[i].prdctCode = sortNum;
		printf("Código do produto: %d", product[i].prdctCode);
		printf("\nQuantidade do produto: ");
		scanf(" %d", &product[i].prdctQtt);
		printf("Valor do produto: ");
		scanf(" %f", &product[i].prdctPrice);
		i++;
		system("cls");
		printf("\t###PRODUTO CADASTRADO###\n\n");
		system("pause");
		system("cls");
	}
}

void prdctList(){
	if(emptyList()){
		system("cls");	
		printf("\t###LISTA DE PRODUTOS VAZIA###\n\n");
		system("pause");
		system("cls");
	} else {
		system("cls");
		printf("\t###LISTA DE PRODUTOS###\n\n");
		for(int x = 0;x < i;x++){
			printf("Produto %d:", x + 1);
			printf("\nNome: %s", product[x].prdctName);
			printf("\nCódigo: %d", product[x].prdctCode);
			printf("\nQuantidade em estoque: %d", product[x].prdctQtt);
			printf("\nValor: %.2f\n\n", product[x].prdctPrice);
		}
		system("pause");
		system("cls");
	}
}

int prdctNameSearch(char name[50]) {
    for(int y = 0; y < i; y++) { 
        if(strcmp(product[y].prdctName, name) == 0) {
            return y;
        }
    }
    return -1;
}

int prdctCodeSearch(int code) {
    for(int z = 0; z < i; z++) {
        if(product[z].prdctCode == code) {
            return z;
        }
    }
    return -1;
}

void prdctSearch(){
	int position, option, code;
	char name[50];
	if(emptyList()){
		system("cls");
		printf("\t###LISTA DE PRODUTOS VAZIA###\n\n");
		system("pause");
		system("cls");
	} else {
		system("cls");
		printf("\t###BUSCA DE PRODUTOS###\n\n");
		printf("1 - Buscar por nome");
		printf("\n2 - Buscar por código");
		printf("\nEscolha sua opção: ");
		scanf(" %d", &option);
			if (option == 1){
            printf("\nDigite o nome do produto: ");
            scanf(" %s", &name);
            position = prdctNameSearch(name);
            if(position != -1) {
                system("cls");
                printf("\t###PRODUTO ENCONTRADO###\n\n");
				printf("\nNome: %s", product[position].prdctName);
				printf("\nCódigo: %d", product[position].prdctCode);
				printf("\nQuantidade em estoque: %d", product[position].prdctQtt);
				printf("\nValor: %.2f\n\n", product[position].prdctPrice);
                system("pause");
                system("cls");
            } else {
                system("cls");
                printf("\t###PRODUTO NÃO ENCONTRADO###\n\n");
                system("pause");
                system("cls");
            }
        	} else if (option == 2) {
            printf("\nDigite o código do produto: ");
            scanf(" %d", &code);
            position = prdctCodeSearch(code);
            if(position != -1) {
                system("cls");
                printf("\t###PRODUTO ENCONTRADO###\n\n");
				printf("\nNome: %s", product[position].prdctName);
				printf("\nCódigo: %d", product[position].prdctCode);
				printf("\nQuantidade em estoque: %d", product[position].prdctQtt);
				printf("\nValor: %.2f\n\n", product[position].prdctPrice);
                system("pause");
                system("cls");
            } else {
                system("cls");
                printf("\t###PRODUTO NÃO ENCONTRADO###\n\n");
                system("pause");
                system("cls");
            }
        }
	}					
}

void goodBye(){
	system("cls");
	printf("\t###FINALIZANDO SISTEMA###");
	abort();
}

int main(){
	setlocale(LC_ALL, "");		
	while(op != 4){
		printf("\t###TMT SISTEMAS###\n\n");
		printf("1 - Cadastrar produto");
		printf("\n2 - Listar produtos");
		printf("\n3 - Buscar produtos");
		printf("\n4 - Sair");
		printf("\nDigite sua escolha: ");
		scanf(" %d", &op);
		fflush(stdin);
		
		switch(op){
			case 1:
				prdctRegister();
				break;
			case 2:
				prdctList();
				break;
			case 3:
				prdctSearch();
				break;
			case 4:
				goodBye();
				break;
			default:
				break;
		}
	}
}