package Aula03.Atividade15;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    protected String nome;
    protected String raca;

    public Animal(String name){
        this.nome = name;
    }

    public String getnome(){
        return nome;
    }
    public String getraca(){
        return raca;
    }
    public void setnome(String name){
        this.nome = name;
    }
    public void setraca(String race){
        this.raca = race;
    }

    public String walk(){
        return "Andou";
    }
    public static void main(String[] args) {
        List<Animal> animais = new ArrayList<>();
        Cachorro c = new Cachorro("Marselo", "Pastor Alemão");
        Gato g = new Gato("Babidi", "Jão");
        animais.add(g);
        animais.add(c);
        System.out.println(g.meowth());
        System.out.println(c.bark() + c.bark());
    }
}
