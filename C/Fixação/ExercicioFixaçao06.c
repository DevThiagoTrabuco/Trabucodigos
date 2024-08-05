#include <stdio.h>
#include<string.h>
#include<stdlib.h>
#include<conio.h>

void calcularDuracao(int hora_inicio, int minuto_inicio, int hora_termino, int minuto_termino, int *duracao_horas, int *duracao_minutos) {
    int minutos_inicio = hora_inicio * 60 + minuto_inicio;
    int minutos_termino = hora_termino * 60 + minuto_termino;
    
    if (minutos_termino < minutos_inicio) {
        minutos_termino += 24 * 60;
    }
    int duracao_minutos_total = minutos_termino - minutos_inicio;
    *duracao_horas = duracao_minutos_total / 60;
    *duracao_minutos = duracao_minutos_total % 60;
}

int main() {
    int hora_inicio, minuto_inicio, hora_termino, minuto_termino;
    int duracao_horas, duracao_minutos;
    
    printf("Digite a hora de início (hora minuto): ");
    scanf("%d %d", &hora_inicio, &minuto_inicio);
    printf("Digite a hora de término (hora minuto): ");
    scanf("%d %d", &hora_termino, &minuto_termino);

    calcularDuracao(hora_inicio, minuto_inicio, hora_termino, minuto_termino, &duracao_horas, &duracao_minutos);
    printf("Duração do jogo: %d horas e %d minutos\n", duracao_horas, duracao_minutos);
}
