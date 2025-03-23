package com.thiago.atividade_lanche03.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thiago.atividade_lanche03.entities.Lanche;
import com.thiago.atividade_lanche03.interfaces.LancheRepository;
import com.thiago.atividade_lanche03.repositories.jpa.LancheJpa;

@Repository
public class LancheRepositoryMySQLImpl implements LancheRepository{

    private final LancheJpa lancheJpa;

    @Autowired
    public LancheRepositoryMySQLImpl(LancheJpa lancheJpa) {
        this.lancheJpa = lancheJpa;
    }

    @Override
    public Lanche getById(int id) {
        return this.lancheJpa.findById(id).orElse(null);
    }

    @Override
    public List<Lanche> list() {
        return this.lancheJpa.findAll();
    }

    @Override
    public void add(Lanche lanche) {
        this.lancheJpa.save(lanche);
    }

    @Override
    public void remove(int id) {
        this.lancheJpa.deleteById(id);
    }

    @Override
    public void update(int id, Lanche lanche) {
        Lanche lancheInDB = this.lancheJpa.findById(id).orElse(null);

        lancheInDB.setName(lanche.getName());
        lancheInDB.setImage(lanche.getImage());
        lancheInDB.setPrice(lanche.getPrice());
        this.lancheJpa.save(lancheInDB);
    }

}
