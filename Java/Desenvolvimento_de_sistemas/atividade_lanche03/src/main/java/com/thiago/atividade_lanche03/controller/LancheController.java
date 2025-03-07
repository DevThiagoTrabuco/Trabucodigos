package com.thiago.atividade_lanche03.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiago.atividade_lanche03.application.LancheApplication;
import com.thiago.atividade_lanche03.entities.Lanche;
import com.thiago.atividade_lanche03.facade.LancheFacade;
import com.thiago.atividade_lanche03.repositories.LancheRepository;
import com.thiago.atividade_lanche03.services.LancheService;

@RestController
@RequestMapping("/api/")
public class LancheController {

    public static LancheRepository lancheRepository;
	public static LancheService lancheService;
	public static LancheApplication lancheApplication;
	public static LancheFacade lancheFacade;

	private static void injectDependencies() {
		lancheRepository = new LancheRepository();
		lancheService = new LancheService();
		lancheApplication = new LancheApplication(lancheRepository, lancheService);
		lancheFacade = new LancheFacade(lancheApplication);
	}

    public LancheController() {
        injectDependencies();

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

    @PatchMapping("/{id}")
    public void update(@RequestBody Lanche lanche){
        lancheFacade.update(lanche.getCode(), lanche);
    }

    @DeleteMapping("/{id}")
    public void remove(@RequestBody int id){
        lancheFacade.remove(id);
    }

    @PostMapping("/buy")
    public void comprar(@RequestBody int id, @RequestBody int qtt) {
        Lanche lanche = lancheFacade.getBycode(id);
        if (lanche != null) {
            lancheFacade.chargePrice(lanche, qtt);
        }
    }
}
