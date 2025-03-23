package com.thiago.atividade_lanche03.repositories;

import java.util.ArrayList;
import java.util.List;


import com.thiago.atividade_lanche03.entities.Lanche;
import com.thiago.atividade_lanche03.interfaces.LancheRepository;


public class LancheRepositoryImpl implements LancheRepository{
    private List<Lanche> lanches = new ArrayList<>();

    public Lanche getById(int code){
        Lanche lanche = lanches
        .stream()
        .filter(l -> l.getId() == code)
        .findFirst()
        .orElse(null);

        return lanche;
    }

    public List<Lanche> list(){
        return lanches;
    }

    public void add(Lanche lanche){
        lanches.add(lanche);
    }

    public void remove(int code){
        lanches.removeIf(l -> l.getId() == code);
    }

    public void update(int code, Lanche lanche){
        Lanche l = this.getById(code);
        l.setName(lanche.getName());
        l.setImage(lanche.getImage());
        l.setPrice(lanche.getPrice());
    }
}