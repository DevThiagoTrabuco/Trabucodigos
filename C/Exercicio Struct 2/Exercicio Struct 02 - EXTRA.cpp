/*Crie estruturas para armazenar as informações de Alunos e Professores.
> Alunos:
Nome, CPF, data de nascimento, email, telefone, celular, 
estado, cidade, bairro, logradouro, matricula, curso
> Professores:
Nome, CPF, data de nascimento, email, telefone, celular, 
estado, cidade, bairro, logradouro, registro, area*/

#include<stdio.h>
#include<string.h>
#include<stdlib.h>

#define MAX_CHAR 50
#define MAX_ENTRYS 10

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
