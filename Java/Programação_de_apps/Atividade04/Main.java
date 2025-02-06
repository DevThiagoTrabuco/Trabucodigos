package Atividade04;

import java.util.Scanner;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ControleTv control = new ControleTv(0, 50);
        int op = 10;
        while(op != 0){
            System.out.println("Volume atual: " + control.getvolume());
            System.out.println("Canal atual: " + control.getchannel());
            System.out.println("[1] - Aumentar volume\n[2] - Abaixar volume\n[3] - Mudar de canal\n[0] - Sair");
            op = new Scanner(System.in).nextInt();

            if(op == 1){
                control.aumentarVol();
            } else if (op == 2 && control.getvolume() > 0){
                control.abaixarVol();
            } else if (op == 3){
                System.out.println("Digite o canal que deseja acessar: ");
                int canal = new Scanner(System.in).nextInt();
                control.setchannel(canal);
            } else {
                op = 0;
            }
        }
    }
}
