//Algoritmo com Função 5:
#include <stdio.h>
#include <stdlib.h>

int ler() {
    int *a;
    a = (int *)malloc(sizeof(int));

    printf("Digite seu ano de nascimento: ");
    scanf("%d", a);

    return *a;
}

int calcular(int *a) {
    int *i;
    i = (int *)malloc(sizeof(int));

    *i = 2024 - *a;
    return *i;
}

void apresentar(int *i) {
    printf("\nIdade: Aproximadamente %d anos de idade", *i);
}

int main() {
    int *ano;
    int *idade;
    ano = (int *)malloc(sizeof(int));
    idade = (int *)malloc(sizeof(int));

    *ano = ler();
    *idade = calcular(ano);

    apresentar(idade);

    free(ano);
    free(idade);

    return 0;
}
