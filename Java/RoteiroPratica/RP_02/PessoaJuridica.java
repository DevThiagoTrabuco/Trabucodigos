package RP_02;

import java.util.List;

public class PessoaJuridica extends Pessoa
    implements IPessoa{
    protected String cnpj;

    public PessoaJuridica(int id, int idade, String nome, String cnpj) {
        super(id, idade, nome);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    @Override
    public List<Pessoa> cadastrarPessoa(int id, String nome, int idade, String cpf_cnpj, List<Pessoa> pessoas) {
        pessoas.add(new PessoaJuridica(id, idade, nome, cnpj));
        return pessoas;
    }

    @Override
	public void editar(List<Pessoa> pessoas, int id, String nome, String cpf, int idade) {
		for (Pessoa pessoa : pessoas) {
			int index = pessoas.indexOf(pessoa);
			
			if(pessoas.get(index) instanceof PessoaJuridica && pessoa.getId() == id) {
				PessoaJuridica pessoaJuridica = (PessoaJuridica) pessoas.get(index);
				
				pessoaJuridica.setNome(nome);
				pessoaJuridica.setCnpj(cnpj);
				pessoaJuridica.setIdade(idade);
				
			}
		}
	}
	
	@Override
	public String buscar(List<Pessoa> pessoas, int id) {
		for (Pessoa pessoa : pessoas) {
			int index = pessoas.indexOf(pessoa);
			if(pessoas.get(index) instanceof PessoaJuridica && pessoa.getId() == id) {
				PessoaJuridica pessoaJuridica = (PessoaJuridica) pessoas.get(index);
		
				return "\nId: "+ pessoaJuridica.getId()
				+"\nNome: "+ pessoaJuridica.getNome()
				+ "\nIdade: "+pessoaJuridica.getIdade()
				+"\nCnpj: "+pessoaJuridica.getCnpj()
				+"\n";
			}
		}
		return "\nNão encontrado";
	}
}
