package Aula04;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> pessoas = new ArrayList<>();
        pessoas.add("Marselo");
        pessoas.add(1, "Gularte");

        pessoas.addFirst("Nando Moura");
        pessoas.addLast("Sheipado");
        
        List<String> pessoas2 = new ArrayList<>();
        pessoas2.add("Vinicin");
        pessoas2.add("Renan");

        pessoas.addAll(pessoas2);

        System.out.println(pessoas.contains("Marselo"));
        System.out.println(pessoas.contains("Marcelo"));
        System.out.println(pessoas.containsAll(pessoas2));
        System.out.println(pessoas);

        System.out.println(pessoas.get(4));
        System.out.println(pessoas.getFirst());
        System.out.println(pessoas.getLast());
        System.out.println(pessoas);

        System.out.println(pessoas.indexOf("Nando Moura"));
        System.out.println(pessoas.lastIndexOf("Renan"));
        System.out.println(pessoas.isEmpty());
        System.out.println(pessoas);

        pessoas.remove("Gularte");
        System.out.println(pessoas);
        pessoas.remove(4);
        System.out.println(pessoas);
        pessoas.removeFirst();
        System.out.println(pessoas);
        pessoas.removeLast();
        System.out.println(pessoas);
        pessoas.removeAll(pessoas2);
        System.out.println(pessoas);

        System.out.println(pessoas.reversed());
        System.out.println(pessoas);

        pessoas.addAll(pessoas2);
        pessoas.set(1, "Vei da Havan");
        System.out.println(pessoas);
        System.out.println(pessoas.subList(0, 2));

        Object[] toArray = pessoas.toArray();
        
        pessoas.clear();
        System.out.println(pessoas);
    }
}
