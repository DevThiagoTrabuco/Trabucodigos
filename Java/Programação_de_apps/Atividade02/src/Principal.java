import java.util.Scanner;

public class Principal {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Quadrado q1 = new Quadrado(4);
        System.out.println("Lado de q1: " + q1.getside());
        System.out.println("Área de q1: " + q1.calcularArea(q1.getside()));
        System.out.println("Digite o novo lado do quadrado q1");
        int lado = new Scanner(System.in).nextInt();
        q1.setside(lado);
        System.out.println("Novo lado de q1: " + q1.getside());
        System.out.println("Nova área de q1: " + q1.calcularArea(q1.getside()));
    }
}
