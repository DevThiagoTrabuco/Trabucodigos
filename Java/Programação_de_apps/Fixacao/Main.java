package Fixacao;

import java.util.Scanner;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		boolean sair = false;
		
		while(!sair) {
			System.out.println("\nEscolha uma opção:"
					+ "\n1- Criar Circulo."
					+ "\n2- Criar Retangulo."
					+ "\n3- Criar Triangulo"
					+ "\n4- Sair.");
			int option = new Scanner(System.in).nextInt();
			
			switch(option) {
				case 1:
					System.out.println("Digite o tamanho do centro do triangulo.");
					double raio = new Scanner(System.in).nextDouble();
					
					Circulo circulo = new Circulo(raio);
					
					System.out.println("\nArea do Circulo: "+circulo.area()+"cm.");
					System.out.println("Perimetro do Circulo: "+circulo.perimetro()+"cm.");
					break;
				case 2:
					System.out.println("Digite a base do retangulo.");
					double base = new Scanner(System.in).nextDouble();
					
					System.out.println("Digite a altura do retangulo.");
					double altura = new Scanner(System.in).nextDouble();
					
					Retangulo retangulo = new Retangulo(base, altura);
					
					System.out.println("\nArea do Retangulo: "+retangulo.area()+"cm.");
					System.out.println("Perimetro do Retangulo: "+retangulo.perimetro()+"cm.");
					break;
				case 3:
					System.out.println("Digite o side A do triangulo.");
					double sideA = new Scanner(System.in).nextDouble();
					
					System.out.println("Digite o side A do triangulo.");
					double sideB = new Scanner(System.in).nextDouble();
					
					System.out.println("Digite o side A do triangulo.");
					double sideC = new Scanner(System.in).nextDouble();
					
					Triangulo triangulo = new Triangulo(sideA, sideB, sideC);
					
					System.out.println("\nArea do Triangulo: "+triangulo.area()+"cm.");
					System.out.println("Perimetro do Triangulo: "+triangulo.perimetro()+"cm.");
					break;
				case 4:
					sair = true;
					break;
			}
		}
	}
}

