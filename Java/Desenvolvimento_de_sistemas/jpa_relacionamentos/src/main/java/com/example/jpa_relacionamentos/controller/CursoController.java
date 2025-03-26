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
import com.example.jpa_relacionamentos.entidades.Professor;
import com.example.jpa_relacionamentos.repositories.CursoRepository;
import com.example.jpa_relacionamentos.repositories.ProfessorRepository;

@RequestMapping("/api/curso/")
@RestController
public class CursoController {
    private final CursoRepository cursoRepository;
    private final ProfessorRepository professorRepository;

    @Autowired
    public CursoController(CursoRepository cursoRepository, ProfessorRepository professorRepository) {
        this.cursoRepository = cursoRepository;
        this.professorRepository = professorRepository;
    }

    @GetMapping("")
    public List<Curso> getAll(){
        return cursoRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public Curso getById(@PathVariable int codigo){
        return cursoRepository.findById(codigo).get();
    }

    @PostMapping("")
    public void save(@RequestBody Curso curso){
        Professor professor = this.professorRepository.findById(curso.getProfessor().getId()).get();
        curso.setProfessor(professor);
        cursoRepository.save(curso);
    }

    @PutMapping("/{codigo}")
    public void update(@PathVariable int codigo, @RequestBody Curso curso){
        cursoRepository.save(curso);
    }

    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable int codigo){
        cursoRepository.deleteById(codigo);
    }
}
