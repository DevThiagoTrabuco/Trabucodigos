package Aula03.Atividade15;

public class Cachorro extends Animal{
    public Cachorro(String name, String race){
        super(name);
        this.raca = race;
    }

    public String bark(){
        return "Au";
    }
}
