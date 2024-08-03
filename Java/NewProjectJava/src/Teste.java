import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        int num;
        Integer num2;
        //Inteiros
        float nota1;
        Float nota2;
        double nota3;
        Double nota4;
        //Reais
        char letra;
        Character letra2;
        //Um caractere
        char[] texto;
        String texto2 = "Bill";
        //Vários caracteres

        System.out.println("Qual o seu nome?");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Qual a sua idade?");
        int num3 = new Scanner(System.in).nextInt();
        System.out.println("Qual a sua altura?");
        double height = new Scanner(System.in).nextDouble();
    }
}
