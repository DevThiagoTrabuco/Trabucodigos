package com.thiago.atividade_lanche03.interfaces;

import java.util.List;

import com.thiago.atividade_lanche03.entities.Lanche;

public interface LancheRepository {
    public Lanche getById(int code);
    public List<Lanche> list();
    public void add(Lanche lanche);
    public void remove(int code);
    public void update(int code, Lanche lanche);
}
