package com.thiago.atividade_lanche03.repositories;

import java.util.List;

import com.thiago.atividade_lanche03.entities.Lanche;
import com.thiago.atividade_lanche03.interfaces.LancheRepository;

public class LancheRepositoryMySQLImpl implements LancheRepository{

    @Override
    public Lanche getByCode(int code) {
        return null;
    }

    @Override
    public List<Lanche> list() {
        return List.of();
    }

    @Override
    public void add(Lanche lanche) {
    }

    @Override
    public void remove(int code) {
    }

    @Override
    public void update(int code, Lanche lanche) {
    }

}
