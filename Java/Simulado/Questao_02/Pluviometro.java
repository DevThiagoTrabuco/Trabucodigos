package Simulado.Questao_02;

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
        if("Convencional".equals(tipo)){
            peso = 1000;
        } else if("Semiautomatico".equals(tipo)){
            peso = 750;
        } else if("Automatico".equals(tipo)){
            peso = 500;
        }
        return peso;
    }

    public int getCapacidade() {
        if("Convencional".equals(tipo)){
            capacidade = 1000000;
        } else if("Semiautomatico".equals(tipo)){
            capacidade = 750000;
        } else if("Automatico".equals(tipo)){
            capacidade = 500000;
        }
        return capacidade;
    }
    
}
