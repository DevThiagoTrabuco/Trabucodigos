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

import com.example.jpa_relacionamentos.entidades.Curso;
import com.example.jpa_relacionamentos.repositories.CursoRepository;

@RequestMapping("/api/curso/")
@RestController
public class CursoController {
    private final CursoRepository cursoRepository;

    @Autowired
    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @GetMapping("")
    public List<Curso> buscar(){
        return cursoRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public Curso buscarPorCodigo(@PathVariable int codigo){
        return cursoRepository.findById(codigo).get();
    }

    @PostMapping("")
    public void adicionar(@RequestBody Curso curso){
        cursoRepository.save(curso);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody Curso curso){
        cursoRepository.save(curso);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo){
        cursoRepository.deleteById(codigo);
    }
}
