/*Crie estruturas para armazenar as informações de Alunos e Professores.
> Alunos:
Nome, CPF, data de nascimento, email, telefone, celular, 
estado, cidade, bairro, logradouro, matricula, curso
> Professores:
Nome, CPF, data de nascimento, email, telefone, celular, 
estado, cidade, bairro, logradouro, registro, area*/

#include<stdio.h>
#include<string.h>
#include<locale.h>
#include<stdlib.h>

#define MAX_CHAR 50
#define MAX_ENTRYS 10

/* RESPOSTA
typedef struct{
	char name[MAX_CHAR], email[MAX_CHAR], state[MAX_CHAR], city[MAX_CHAR];
	char nghbrhood[MAX_CHAR], street[MAX_CHAR], course[MAX_CHAR]; 
	int cpf, phone, cellPhone, registration;
	int bday, bmonth, byear;
} Student;

typedef struct{
	char name[MAX_CHAR], email[MAX_CHAR], state[MAX_CHAR], city[MAX_CHAR];
	char nghbrhood[MAX_CHAR], street[MAX_CHAR], occupation[MAX_CHAR]; 
	int cpf, phone, cellPhone, registration;
	int bday, bmonth, byear;
} Teacher;
*/

typedef struct{
	char name[MAX_CHAR], email[MAX_CHAR], state[MAX_CHAR], city[MAX_CHAR];
	char nghbrhood[MAX_CHAR], street[MAX_CHAR], course[MAX_CHAR], occupation[MAX_CHAR]; 
	int cpf, phone, cellPhone, registration;
	int bday, bmonth, byear;
} School;

School students[MAX_ENTRYS];
School teachers[MAX_ENTRYS];
int op, s = 0, t = 0;

void studentRegistration(){
	system("cls");
	printf("NOME: ");
	gets(students[s].name);
	printf("EMAIL: ");
	gets(students[s].email);
	printf("DATA DE NASCIMENTO (dd mm aaaa): ");
	scanf(" %d/%d/%d", &students[s].bday, &students[s].bmonth, &students[s].byear);
	printf("CPF: ");
	scanf(" %d", &students[s].cpf);
	printf("CELULAR: ");
	scanf(" %d", &students[s].cellPhone);
	printf("TELEFONE: ");
	scanf(" %d", &students[s].phone);
	printf("MATRÍCULA: ");
	scanf(" %d", &students[s].registration);
	printf("CURSO: ");
	gets(students[s].course);
	printf("ESTADO: ");
	gets(students[s].state);
	printf("CIDADE: ");
	gets(students[s].city);
	printf("BAIRRO: ");
	gets(students[s].nghbrhood);
	printf("LOGRADOURO: \n");
	gets(students[s].street);
	s++;
	system("pause");
	system("cls");
}

void teacherRegistration(){
	system("cls");
	printf("NOME: ");
	gets(teachers[t].name);
	printf("EMAIL: ");
	gets(teachers[t].email);
	printf("DATA DE NASCIMENTO: ");
	scanf(" %d/%d/%d", &teachers[t].bday, &teachers[t].bmonth, &teachers[t].byear);
	printf("CPF: ");
	scanf(" %d", teachers[t].cpf);
	printf("CELULAR: ");
	scanf(" %d", teachers[t].cellPhone);
	printf("TELEFONE: ");
	scanf(" %d", teachers[t].phone);
	printf("REGISTRO: ");
	scanf(" %d", teachers[t].registration);
	printf("ÁREA DE ATUAÇÃO: ");
	gets(teachers[t].occupation);
	printf("ESTADO: ");
	gets(teachers[t].state);
	printf("CIDADE: ");
	gets(teachers[t].city);
	printf("BAIRRO: ");
	gets(teachers[t].nghbrhood);
	printf("LOGRADOURO: \n");
	gets(teachers[t].street);
	t++;
	system("pause");
	system("cls");
}

	int main(){
		setlocale(LC_ALL, "portuguese");
		while(op != 3){
			printf("1 - CADASTRAR ALUNOS");
			printf("\n2 - CADASTRAR PROFESSORES");
			printf("\n3 - SAIR");
			printf("\nESCOLHA: ");
			scanf(" %d", &op);
			fflush(stdin);
			switch(op){
				case 1:
					studentRegistration();
					break;
				case 2:
					teacherRegistration();
					break;
				case 3:
					abort();
					break;
				default:
					printf("\nOPÇÃO INVÁLIDA.\n");
					system("pause");
					system("cls");
					break;
			}
		}
	}