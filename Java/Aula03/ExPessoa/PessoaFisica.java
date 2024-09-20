package Aula03.ExPessoa;

public class PessoaFisica extends Pessoa{
    private String cpf;

    public PessoaFisica(String cpf, String name, int age){
        super(name, age);
        this.cpf = cpf;
    }

    public String getcpf(){
        return cpf;
    }
    
}
