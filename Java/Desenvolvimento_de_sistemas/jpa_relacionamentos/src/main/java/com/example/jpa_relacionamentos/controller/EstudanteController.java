package com.example.jpa_relacionamentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa_relacionamentos.entidades.Estudante;
import com.example.jpa_relacionamentos.repositories.EstudanteRepository;

@RequestMapping("/api/estudante/")
@RestController
public class EstudanteController {
    private final EstudanteRepository estudanteRepository;

    @Autowired
    public EstudanteController(EstudanteRepository estudanteRepository) {
        this.estudanteRepository = estudanteRepository;
    }

    @GetMapping("")
    public List<Estudante> getAll(){
        return estudanteRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public Estudante getById(@PathVariable int codigo){
        return estudanteRepository.findById(codigo).get();
    }

    @PostMapping("")
    public void save(@RequestBody Estudante estudante){
        estudanteRepository.save(estudante);
    }

    @PutMapping("/{codigo}")
    public void update(@PathVariable int codigo, @RequestBody Estudante estudante){
        estudanteRepository.save(estudante);
    }

    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable int codigo){
        estudanteRepository.deleteById(codigo);
    }
}
