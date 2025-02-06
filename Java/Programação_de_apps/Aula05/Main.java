package Aula05;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        //Map<String, String> pessoas = new HashMap<>();
        //Map<String, String> pessoas = new LinkedHashMap<>();
        Map<String, String> pessoas = new TreeMap<>();
        pessoas.put("12345649855", "Marselo");
        pessoas.put("12758949855", "Gularte");
        pessoas.put("12358756555", "Nando");
        System.out.println(pessoas.keySet());
        System.out.println(pessoas.values());
    }
}
