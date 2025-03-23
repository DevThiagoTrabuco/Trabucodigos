package com.thiago.atividade_lanche03.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thiago.atividade_lanche03.application.LancheApplication;
import com.thiago.atividade_lanche03.entities.Lanche;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class LancheFacade {
    @Autowired
    private LancheApplication lancheApplication;

    public void add(Lanche lanche){
        this.lancheApplication.add(lanche);
    }

    public void update(int id, Lanche lanche){
        this.lancheApplication.update(id, lanche);
    }

    public void remove(int id){
        this.lancheApplication.remove(id);
    }

    public List<Lanche> list(){
        return this.lancheApplication.list();
    }

    public Lanche getById(int id){
        return this.lancheApplication.getById(id);
    }

    public double chargePrice(Lanche lanche, int qtt){
        return this.lancheApplication.chargePrice(lanche, qtt);
    }

}