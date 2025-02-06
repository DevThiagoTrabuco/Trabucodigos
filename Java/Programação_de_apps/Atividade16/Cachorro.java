package Atividade16;
@SuppressWarnings("unused")

public class Cachorro implements Animal{
    private String raca, nome;
    private int idade;

    public Cachorro(String raca, String nome, int idade){
        this.raca = raca;
        this.nome = nome;
        this.idade = idade;
    }

    public String bark(){
        return "Rhoulf";
    }

    @Override
    public String walk() {
        return "Andou";
    }
    
}
