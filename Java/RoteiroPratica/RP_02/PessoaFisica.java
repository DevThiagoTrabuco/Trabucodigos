package RP_02;

import java.util.List;

public class PessoaFisica extends Pessoa
	implements IPessoa{
    protected String cpf;
    
    public PessoaFisica(int id, int idade, String nome, String cpf) {
        super(id, idade, nome);
        this.cpf = cpf;
    }
    
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

    public String getCpf() {
		return cpf;
    }
    
    @Override
    public List<Pessoa> cadastrarPessoa(int id, String nome, int idade, String cpf_cnpj, List<Pessoa> pessoas) {
        pessoas.add(new PessoaFisica(id, idade, nome, cpf));
        return pessoas;
    }

    @Override
	public void editar(List<Pessoa> pessoas, int id, String nome, String cpf, int idade) {
		for (Pessoa pessoa : pessoas) {
			int index = pessoas.indexOf(pessoa);
			
			if(pessoas.get(index) instanceof PessoaFisica && pessoa.getId() == id) {
				PessoaFisica pessoaFisica = (PessoaFisica) pessoas.get(index);
				
				pessoaFisica.setNome(nome);
				pessoaFisica.setCpf(cpf);
				pessoaFisica.setIdade(idade);
				
			}
		}
	}
	
	@Override
	public String buscar(List<Pessoa> pessoas, int id) {
		for (Pessoa pessoa : pessoas) {
			int index = pessoas.indexOf(pessoa);
			
			if(pessoas.get(index) instanceof PessoaFisica && pessoa.getId() == id) {
				PessoaFisica pessoaFisica = (PessoaFisica) pessoas.get(index);
		
				return "\nId: "+ pessoaFisica.getId()
				+"\nNome: "+ pessoaFisica.getNome()
				+ "\nIdade: "+pessoaFisica.getIdade()
				+"\nCpf: "+pessoaFisica.getCpf()
				+"\n";
			}
		}
		return "\nNão encontrado";
	}
}
