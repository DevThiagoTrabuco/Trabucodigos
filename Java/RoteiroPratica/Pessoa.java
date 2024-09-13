package RoteiroPratica;

public class Pessoa {
    private String name, cpf;
    private int birthYear;

    public Pessoa(String name, String cpf, int birthYear){
        this.name = name;
        this.cpf = cpf;
        this.birthYear = birthYear;
    }

    public String getname(){
        return name;
    }
    public String getcpf(){
        return cpf;
    }
    public int getyear(){
        return birthYear;
    }
}
