package RP_02;

import java.util.List;

public interface IPessoa {
    public void editar(List<Pessoa> pessoas, int id, String nome, String cpf, int idade);
    public String buscar(List<Pessoa> pessoas, int id);
}
