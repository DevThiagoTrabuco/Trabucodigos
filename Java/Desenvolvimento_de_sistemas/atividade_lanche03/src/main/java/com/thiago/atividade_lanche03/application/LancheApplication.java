package com.thiago.atividade_lanche03.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thiago.atividade_lanche03.entities.Lanche;
import com.thiago.atividade_lanche03.interfaces.LancheRepository;
import com.thiago.atividade_lanche03.services.LancheService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class LancheApplication {
    @Autowired
    private LancheRepository lancheRepository;
    @Autowired
    private LancheService lancheService;
    

    public void add(Lanche lanche){
        this.lancheRepository.add(lanche);
        this.lancheService.save(lanche);
    }

    public void update(int id, Lanche lanche){
        this.lancheRepository.update(id, lanche);
        this.lancheService.save(lanche);
    }

    public void remove(int id){
        Lanche lanche = this.lancheRepository.getById(id);
        if(lanche != null){
            this.lancheRepository.remove(id);
            this.lancheService.delete(lanche);
        }
    }

    public List<Lanche> list(){
        return this.lancheRepository.list();
    }

    public Lanche getById(int id){
        return this.lancheRepository.getById(id);
    }

    public double chargePrice(Lanche lanche, int qtt){
        return lanche.getPrice() * qtt;
    }

}
