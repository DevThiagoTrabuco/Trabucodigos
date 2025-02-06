package Aula03.ExAnimal;

public class Pinscher extends Cachorro{
    private int tamanho;

    public Pinscher(String nome, int idade, String cor, int tamanho){
        super(nome, idade, cor);
        this.tamanho = tamanho;
    }

    public int gettamanho(){
        return tamanho;
    }
    public void settamanho(int tamanho){
        this.tamanho = tamanho;
    }
}
