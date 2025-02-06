package Atividade01;

public class Principal {
    public static void main(String[] args) {
        Bola b1 = new Bola("Roxa");
        System.out.println("Minha bola encontra-se " + b1.getColor());
        b1.setColor("Azul");
        System.out.println("Agora minha bola está " + b1.getColor());
    }
}
