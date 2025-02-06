package Aula05;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Dog {
    @SuppressWarnings("FieldMayBeFinal")
    private int idade;

    public Dog(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Dog [idade=" + idade + "]";
    }
    
    public static void main(String[] args) {
        Set<Dog> dogs = new HashSet<>();
        dogs.add(new Dog(1));
        dogs.add(new Dog(2));
        dogs.add(new Dog(3));
        dogs.add(new Dog(4));
        dogs.add(new Dog(5));

        for (Dog dog : dogs){
            System.out.println(dog);
        }

        Set<Integer> ints = new TreeSet<>();
        ints.add(2);
        ints.add(4);
        ints.add(1);
        ints.add(5);
        ints.add(3);

        for(Integer inte : ints){
            System.out.println(inte);
        }

        Set<Dog> cats = new LinkedHashSet<>();
        cats.add(new Dog(2));
        cats.add(new Dog(5));
        cats.add(new Dog(1));
        cats.add(new Dog(3));
        cats.add(new Dog(4));

        for (Dog dog : cats){
            System.out.println(dog);
        }
    }
}
