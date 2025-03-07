package com.thiago.atividade_lanche03.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.thiago.atividade_lanche03.entities.Lanche;

@Repository
@Component
public class LancheRepository {
    private List<Lanche> lanches = new ArrayList<>();

    public Lanche getByCode(int code){
        Lanche lanche = lanches
        .stream()
        .filter(l -> l.getCode() == code)
        .findFirst()
        .get();

        return lanche;
    }

    public List<Lanche> list(){
        return lanches;
    }

    public void add(Lanche lanche){
        lanches.add(lanche);
    }

    public void remove(int code){
        lanches.removeIf(l -> l.getCode() == code);
    }

    public void updateLanche(int code, Lanche lanche){
        Lanche l = this.getByCode(code);
        l.setName(lanche.getName());
        l.setImagePath(lanche.getImagePath());
        l.setPrice(lanche.getPrice());
    }

    public boolean estaVazio(){
        return lanches.isEmpty();
    }
}