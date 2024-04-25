/*Criar uma STRUCT com os seguintes elementos:
 Nome  Idade  Tel  E-mail  Usuário  Senha
a. Permitir cadastro apenas maiores de idade
b. Verificar se usuário e senha possuem 8 dígitos
c. Lista as informações cadastradas*/
#include<stdio.h>
#include<string.h>
#include<locale.h>
#include<stdlib.h>

#define MAX_CHAR 100
#define MAX_USER 10

typedef struct {
	char userName[MAX_CHAR];
	char userEmail[MAX_CHAR];
	char userUsername[MAX_CHAR];
	char userPass[MAX_CHAR];
	int userAge;
	int userPhone;
} UserList;

UserList users[MAX_USER];
int op, i = 0;

bool emptyList(){
	if(i == 0){
		return true;
	}
	return false;
}

bool fullList(){
	if (i == MAX_USER){
		return true;
	}
	return false;
}

void userRegistration(){
	if(fullList()){
		system("cls");
		printf("\t###LISTA DE CADASTROS CHEIA###\n\n");
		system("pause");
		system("cls");
	} else {
		system("cls");
		printf("Nome: ");
		gets(users[i].userName);
		printf("Idade: ");
		scanf(" %d", &users[i].userAge);
		if (users[i].userAge < 18){
			printf("Cadastro apenas para maiores de 18 anos.\n");
			system("pause");
			system("cls");
		} 
		else {
			printf("Telefone (Ex: 912345678): ");
			scanf(" %d", &users[i].userPhone);
			fflush(stdin);
			printf("Email: ");
			gets(users[i].userEmail);
			fflush(stdin);
			do{
				printf("Usuário: ");
				gets(users[i].userUsername);
				if (strlen(users[i].userUsername) < 8){
					printf("Minímo de 8 carateres para usuário.\n");
					system("pause");
					system("cls");
				}
			} while (strlen(users[i].userUsername) < 8);
			do{
				printf("Senha: ");
				gets(users[i].userPass);
				if (strlen(users[i].userPass) < 8){
					printf("Minímo de 8 carateres para senha.\n");
					system("pause");
					system("cls");
				}
			} while (strlen(users[i].userPass) < 8);
		i++;
		system("pause");
		system("cls");
		}
	}
}

void userList(){
	if(emptyList()){
		system("cls");	
			printf("\n\t###LISTA VAZIA###\n\n");
			system("pause"); 
			system("cls");
		} else {
		system("cls");
		for(int x = 0;x < i;x++){
			printf("%s", users[x].userName);
			printf("\n%d", users[x].userAge);
			printf("\n%d", users[x].userPhone);
			printf("\n%s", users[x].userEmail);
			printf("\n%s", users[x].userUsername);
			printf("\n%s", users[x].userPass);
			printf("\n\n");
		}
		system("pause");
		system("cls");
	}
}

	int main(){
		setlocale(LC_ALL, "portuguese");
		while(op != 3){
			system("cls");
			printf("1 - Cadastrar");
			printf("\n2 - Listar cadastros");
			printf("\n3 - Sair");
			printf("\nEscolha: ");
			scanf(" %d", &op);
			fflush(stdin);
			switch(op){
				case 1:
					userRegistration();
					break;
				case 2:
					userList();
					break;
				case 3:
					abort();
					break;
				default:
					break;
			}
		}
	}