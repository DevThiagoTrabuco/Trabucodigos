package com.thiago.atividade_lanche03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
@RequestMapping("/lanche")
public class AtividadeLanche03Application {

	public static void main(String[] args) {
		SpringApplication.run(AtividadeLanche03Application.class, args);
	}

}
