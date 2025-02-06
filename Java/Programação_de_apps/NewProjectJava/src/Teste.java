import java.util.Scanner;

public class Teste {
    @SuppressWarnings({ "unused", "resource" })
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

        //Declaração de arrays e matrizes
        int [] age = new int [5];

        char [] word;
        word = new char [5];

        int [][] matriz = new int[5][4];
        double [][] matriz2; 
        matriz2 = new double[5][4];

        calculaNota(1.5, 9.5);
    }
    public static double calculaNota(double grade1, double grade2){
        return (grade1 + grade2)/2;
    }
}
