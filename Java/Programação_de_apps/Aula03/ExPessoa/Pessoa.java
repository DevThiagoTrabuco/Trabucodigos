package Aula03.ExPessoa;

public class Pessoa {
    protected String nome;
    protected int idade;

    public Pessoa(String name, int age){
        this.nome = name;
        this.idade = age;
    }

    public String getnome(){
        return nome;
    }
    public int getidade(){
        return idade;
    }
}
