package com.thiago.atividade_lanche03.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thiago.atividade_lanche03.entities.Lanche;
import com.thiago.atividade_lanche03.repositories.LancheRepository;
import com.thiago.atividade_lanche03.services.LancheService;

public class LancheApplication {
    @Autowired
    private LancheRepository lancheRepository;
    @Autowired
    private LancheService lancheService;

    public void add(Lanche lanche){
        this.lancheRepository.add(lanche);
        this.lancheService.save(lanche);
    }

    public void update(int code, Lanche lanche){
        this.lancheRepository.updateLanche(code, lanche);
        this.lancheService.save(lanche);
    }

    public void remove(int code){
        this.lancheRepository.remove(code);
        this.lancheService.delete(this.lancheRepository.getByCode(code));
    }

    public List<Lanche> list(){
        return this.lancheRepository.list();
    }

    public Lanche getByCode(int code){
        return this.lancheRepository.getByCode(code);
    }

    public double chargePrice(Lanche lanche, int qtt){
        return lanche.getPrice() * qtt;
    }

    public boolean estaVazio(){
        return this.lancheRepository.estaVazio();
    }
}
