package RP_02;

import java.util.List;

public class Pessoa {
    protected int id;
    protected int idade;
    protected String nome;

    public Pessoa(int id, int idade, String nome) {
        this.id = id;
        this.idade = idade;
        this.nome = nome;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public List<Pessoa> cadastrarPessoa(int id, String nome, int idade, String cpf_cnpj, List<Pessoa> pessoas){
        return pessoas;
    }
}
