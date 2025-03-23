package com.thiago.atividade_lanche03.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiago.atividade_lanche03.entities.Lanche;

public interface LancheJpa extends JpaRepository<Lanche, Integer> {
    
}
