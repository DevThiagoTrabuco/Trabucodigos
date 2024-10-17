package RoteiroPratica.RP02;

import java.util.List;

public interface IPessoa {
    public void editar(List<Pessoa> pessoas, int id);
    public String buscar(List<Pessoa> pessoas, int id);
}
