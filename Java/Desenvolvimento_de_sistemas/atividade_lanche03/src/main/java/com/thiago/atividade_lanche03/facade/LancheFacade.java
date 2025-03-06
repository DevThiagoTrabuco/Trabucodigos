package com.thiago.atividade_lanche03.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thiago.atividade_lanche03.application.LancheApplication;
import com.thiago.atividade_lanche03.entities.Lanche;

public class LancheFacade {
    @Autowired
    private LancheApplication lancheApplication;

    public void add(Lanche lanche){
        this.lancheApplication.add(lanche);
    }

    public void update(int code, Lanche lanche){
        this.lancheApplication.update(code, lanche);
    }

    public void remove(int code){
        this.lancheApplication.remove(code);
    }

    public List<Lanche> list(){
        return this.lancheApplication.list();
    }

    public Lanche getBycode(int code){
        return this.lancheApplication.getByCode(code);
    }

    public double chargePrice(Lanche lanche, int qtt){
        return this.lancheApplication.chargePrice(lanche, qtt);
    }

    public boolean estaVazio(){
        return this.lancheApplication.estaVazio();
    }
}