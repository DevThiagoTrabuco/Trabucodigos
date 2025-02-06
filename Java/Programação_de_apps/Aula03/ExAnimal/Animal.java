package Aula03.ExAnimal;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    protected String nome;
    protected int idade;

    public Animal(String name, int age){
        this.nome = name;
        this.idade = age;
    }

    public String getnome(){
        return nome;
    }
    public int getidade(){
        return idade;
    }
    public void setnome(String name){
        this.nome = name;
    }
    public void setidade(int age){
        this.idade = age;
    }
    public static void main(String[] args) {
        List<Animal> animais = new ArrayList<>();
        Cachorro c = new Cachorro("Marselo", 12, "preto");
        Pinscher p = new Pinscher("Jorje", 3, "Laranja", 50);
        animais.add(c);
        animais.add(p);
    }
}
