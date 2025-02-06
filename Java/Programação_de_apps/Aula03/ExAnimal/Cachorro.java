package Aula03.ExAnimal;

public class Cachorro extends Animal {
    protected String cor;
    
    public Cachorro(String nome, int idade, String color){
        super(nome, idade);
        this.cor = color;
    }

    public String getcor(){
        return cor;
    }
    public void setcor(String color){
        this.cor = color;
    }
}
