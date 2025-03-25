package com.example.jpa_relacionamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa_relacionamentos.entidades.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Integer> {

}
