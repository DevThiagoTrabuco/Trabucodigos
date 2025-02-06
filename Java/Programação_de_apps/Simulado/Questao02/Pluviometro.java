package Simulado.Questao02;

public class Pluviometro {
    protected String tipo;
    protected double peso;
    protected int capacidade;

    public Pluviometro(String tipo, double peso, int capacidade){
        this.tipo = tipo;
        this.peso = peso;
        this.capacidade = capacidade;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPeso() {
        switch (tipo) {
            case "Convencional" -> peso = 1000;
            case "Semiautomatico" -> peso = 750;
            case "Automatico" -> peso = 500;
            default -> {
            }
        }
        return peso;
    }

    public int getCapacidade() {
        switch (tipo) {
            case "Convencional" -> capacidade = 1000000;
            case "Semiautomatico" -> capacidade = 750000;
            case "Automatico" -> capacidade = 500000;
            default -> {
            }
        }
        return capacidade;
    }
    
}
