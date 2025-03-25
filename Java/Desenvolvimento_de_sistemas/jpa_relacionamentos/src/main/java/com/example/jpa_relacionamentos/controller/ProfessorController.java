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

import com.example.jpa_relacionamentos.entidades.Professor;
import com.example.jpa_relacionamentos.repositories.ProfessorRepository;

@RequestMapping("/api/professor/")
@RestController
public class ProfessorController {
    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorController(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @GetMapping("")
    public List<Professor> buscar(){
        return professorRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public Professor buscarPorCodigo(@PathVariable int codigo){
        return professorRepository.findById(codigo).get();
    }

    @PostMapping("")
    public void adicionar(@RequestBody Professor professor){
        professorRepository.save(professor);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody Professor professor){
        professorRepository.save(professor);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo){
        professorRepository.deleteById(codigo);
    }
}
