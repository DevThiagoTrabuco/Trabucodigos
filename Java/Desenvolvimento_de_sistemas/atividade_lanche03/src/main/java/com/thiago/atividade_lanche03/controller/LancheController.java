package com.thiago.atividade_lanche03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thiago.atividade_lanche03.entities.Lanche;
import com.thiago.atividade_lanche03.facade.LancheFacade;

@RestController
@RequestMapping("/api/")
public class LancheController {

   
    private LancheFacade lancheFacade;
    @Autowired
    public LancheController(LancheFacade lancheFacade) {
        this.lancheFacade = lancheFacade;
        Lanche lanche1 = new Lanche("raiz", "jorge", 1.57, 1);
        Lanche lanche2 = new Lanche("raize", "jilson", 1.77, 2);
        Lanche lanche3 = new Lanche("raizes", "marselo", 1.87, 3);

        lancheFacade.add(lanche1);
        lancheFacade.add(lanche2);
        lancheFacade.add(lanche3);
    }

    @GetMapping("")
    public List<Lanche> get(){
        return lancheFacade.list();
    }

    @GetMapping("/{id}")
    public Lanche getLanche(@PathVariable int id){
        return lancheFacade.getBycode(id);
    }

    @PostMapping("")
    public void add(@RequestBody Lanche lanche){
        lancheFacade.add(lanche);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Lanche lanche){
        lancheFacade.update(id, lanche);
    }

    @DeleteMapping("/{id}")
    public void remove(@RequestBody int id){
        lancheFacade.remove(id);
    }

    @GetMapping("/buy")
    public double comprar(@RequestParam int id, @RequestParam int qtt) {
        Lanche lanche = lancheFacade.getBycode(id);
        if (lanche != null) {
            return lancheFacade.chargePrice(lanche, qtt);
        }
        return 0;
    }
}
