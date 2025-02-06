package Atividade05;

public class Funcionario {
    private String name;
    private double wage;

    public Funcionario(String nome, double salario){
        this.name = nome;
        this.wage = salario;
    }

    public String getname(){
        return name;
    }
    public double getwage(){
        return wage;
    }

    public double increaseWage(double percentage){
        wage += (wage*(percentage/100));
        return wage;
    }
}
