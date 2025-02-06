package Atividade06;

public class Pessoa {
    private String name;
    private int age;
    private double weight, height;

    public Pessoa(String nome, int idade, double peso, double altura){
        this.name = nome;
        this.age = idade;
        this.weight = peso;
        this.height = altura;
    }

    public String getname(){
        return name;
    }
    public int getage(){
        return age;
    }
    public double getweight(){
        return weight;
    }
    public double getheight(){
        return height;
    }

    public void growOld(){
        age++;
    }
    public void gainWeight(double massa){
        if(weight <= 100.0){
            weight = weight + massa;
        } else {
            System.out.println("Não é possível aumentar de peso");
        }
    }
    public void loseWeight(double massa){
        if (weight >= 0.0 && weight > massa){
            weight = weight - massa;
        } else {
            System.out.println("Não é possível diminuir a massa");
        }
    }
    public void grow(){
        if(age <= 21 && height <= 1.80){
            height += 0.05;
        }
    }
}
