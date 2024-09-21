package Atividade16;
@SuppressWarnings("unused")

public class Gato implements Animal{
    private String raca, nome;
    private int idade;

    public Gato(String raca, String nome, int idade){
        this.raca = raca;
        this.nome = nome;
        this.idade = idade;
    }

    public String meowth(){
        return "Miau";
    }

    @Override
    public String walk() {
        return "Andou";
    }
    
}
