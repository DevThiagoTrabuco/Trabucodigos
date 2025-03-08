package com.thiago.atividade_lanche03.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thiago.atividade_lanche03.entities.Lanche;
import com.thiago.atividade_lanche03.repositories.LancheRepositoryImpl;
import com.thiago.atividade_lanche03.services.LancheService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class LancheApplication {
    @Autowired
    private LancheRepositoryImpl lancheRepository;
    @Autowired
    private LancheService lancheService;
    

    public void add(Lanche lanche){
        this.lancheRepository.add(lanche);
        this.lancheService.save(lanche);
    }

    public void update(int code, Lanche lanche){
        this.lancheRepository.update(code, lanche);
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

}
